import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.text.SimpleDateFormat
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
object Youtube {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .appName("RDDtoHdfs")
      .getOrCreate()
    import spark.implicits._

    val colSchema = StructType(Seq(StructField("video_id", StringType, true), StructField("trending_date", StringType, true), StructField("title", StringType, true), StructField("channel_title", StringType, true), StructField("category_id", IntegerType, true), StructField("publish_time", DateType, true), StructField("tags", StringType, true), StructField("views", LongType, true), StructField("likes", IntegerType, true), StructField("dislikes", IntegerType, true), StructField("comment_count", IntegerType, true), StructField("thumbnail_link", StringType, true), StructField("comments_disabled", BooleanType, true), StructField("ratings_disabled", BooleanType, true), StructField("video_error_or_removed", BooleanType, true), StructField("description", StringType, true)))

    def dateParser(d: String): java.sql.Date = {
      val pattern = "yy.dd.mm"
      val format = new SimpleDateFormat(pattern);
      return new java.sql.Date(format.parse(d).getTime)
    }


    val dateparserUdf = udf(dateParser(_: String): java.sql.Date)


    val indd = spark.read.format("csv").schema(colSchema).option("header", "true").option("dateFormat", "yyyy-MM-dd HH:mm:ssX").load("hdfs://localhost:50000/Utube/IN*.csv")
    val usd = spark.read.format("csv").schema(colSchema).option("header", "true").option("dateFormat", "yyyy-MM-dd HH:mm:ssX").load("hdfs://localhost:50000/Utube/US*.csv")
    val joinCat = spark.read.format("json").option("header", "true").option("multiline", "true").load("hdfs://localhost:50000/Utube/Cat*/*IN*")
    val cat = joinCat.select(explode($"items").as("value")).select("value.id", "value.snippet.title")


    val s = indd.filter("category_id is not null")
    val s1 = usd.filter("category_id is not null")

    val ind = s;
    val us = s1;

    ind.select(dateparserUdf($"trending_date").as("trending_date"), $"category_id").groupBy("trending_date", "category_id").count.withColumn("everyTendays", sum($"count").over(Window.partitionBy("category_id").orderBy("trending_date").rowsBetween(0, 9)))

    ind.select(dateparserUdf($"trending_date").as("trending_date"), $"category_id").write.bucketBy(4, "trending_date", "category_id").mode("overwrite").saveAsTable("BucketedEnd")

    val inn = spark.sql("select sum(count) over (partition by category_id order by trending_date rows between current row and 9 following) as countOnWhole, * from (select *,count(*) as count from bucketedEnd group by trending_date, category_id)")
    //reduced to one shuffle//


    us.select(dateparserUdf($"trending_date").as("trending_date"), $"category_id").write.bucketBy(4, "trending_date", "category_id").mode("overwrite").saveAsTable("BucketedEndus")

    val uss = spark.sql("select sum(count) over (partition by category_id order by trending_date rows between current row and 9 following) as countOnWhole, * from (select *,count(*) as count from bucketedEndus group by trending_date, category_id)")

    inn.join(uss, inn("trending_date") === uss("trending_date") && inn("category_id") === uss("category_id"), "inner").join(cat, inn("category_id") === cat("id"), "inner").show


  }


}
