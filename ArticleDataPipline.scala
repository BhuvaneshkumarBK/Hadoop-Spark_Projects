import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, month}

object Project1 extends App {
val output="finalOut"
  val database1="jdbc:mysql://localhost:3306/articleData"
    val database2="jdbc:sqlite:/home/bhuvanesh/articleData.db"
  val databaseName="articleData"
  val driver2="org.sqlite.JDBC"
  val spark: SparkSession = SparkSession.builder()
    .appName("RDDtoHdfs")
    .getOrCreate()
  spark.conf.set("spark.sql.autoBroadcastJoinThreshold",16887874)

  val citations = spark.read.format("jdbc").options(
    Map("url" ->  database1,
      "user" -> "bhuvanesh", "password" -> "Bhuvi",  "dbtable" -> s"$databaseName.citations",
      "fetchSize" -> "100000",
      "numPartitions" -> "4"
    )).load()



  val stats = spark.read.format("jdbc").options(
    Map("url" ->  database1,
      "user" -> "bhuvanesh", "password" -> "Bhuvi",  "dbtable" -> s"$databaseName.stats",
      "fetchSize" -> "10000",
      "partitionColumn" -> "Id", "lowerBound" -> "0", "upperBound" -> "5313", "numPartitions" -> "4"
    )).load()





  val article = spark.read.format("jdbc").options(
    Map("url" ->  database1,
      "user" -> "bhuvanesh", "password" -> "Bhuvi",  "dbtable" -> s"$databaseName.articles",
      "fetchSize" -> "10000",
      "partitionColumn" -> "Published", "lowerBound" -> "2020-01-01 00:00:00", "upperBound" -> "2020-12-31 00:00:00", "numPartitions" -> "4"
    )).load()



  val sections = spark.read.format("jdbc").options(
    Map("driver"-> driver2 ,"url" ->  database2,
      "user" -> "bhuvanesh", "password" -> "Bhuvi",  "dbtable" -> "sections",
      "fetchSize" -> "1000000","partitionColumn" -> "Id", "lowerBound" -> "1", "upperBound" -> "350000000000", "numPartitions" -> "12"

    )).load()


  article.createTempView("article")

  citations.createTempView("citations")


  stats.createTempView("stats")
  spark.sql("create database if not exists articleDb ").show
  spark.sql("select id, publication, published, title, source, explode(split((authors),';')) as author from article ").write.mode("overwrite").bucketBy(2, "id").saveAsTable("articleDb.article")
  citations.write.mode("overwrite").bucketBy(1, "title").saveAsTable("articleDb.cit")
  sections.write.bucketBy(9,"article").mode("overwrite").saveAsTable("articleDb.sec")
  spark.sql("use articleDb")
  val finalData=spark.sql("select author, text, name, publication, published,if(mentions is null ,1,mentions) as mentions from (select author, text, name, title, publication, published from articleDb.sec join articleDb.article on article.Id=sec.article) left join articleDb.cit on cit.title=text where publication is not null")

  finalData.withColumn("publishedmonth",month(col("published"))).write.partitionBy("publishedmonth").mode("overwrite").format("parquet").save(output)
}
