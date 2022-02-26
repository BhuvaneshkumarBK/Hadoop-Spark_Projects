import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.util.Properties
object Project3 {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .appName("airPollutionanalysis.com")
      .getOrCreate()


    spark.sparkContext
     .hadoopConfiguration.set("fs.s3a.access.key", "key")
    spark.sparkContext
      .hadoopConfiguration.set("fs.s3a.secret.key", "pass")
    val input="s3a://project--3/india_noNA.csv"
  //  val input="hdfs://localhost:50000/ProjectReal/Project3/orc"
   // val output="hdfs://localhost:50000/ProjectReal/Project3/Result"
    val output="s3a://project--3/airout"
    val schema= StructType(Array(StructField("location",StringType,true), StructField("city",StringType,true), StructField("country",StringType,true), StructField("utc",TimestampType,true), StructField("local",TimestampType,true), StructField("parameter",StringType,true), StructField("value",DoubleType,true), StructField("unit",StringType,true), StructField("latitude",DoubleType,true), StructField("longitude",DoubleType,true), StructField("attribution",StringType,true)))
    val data= spark.read.format("csv").schema(schema).option("header",true).load(input)
   //data.write.format("orc").mode("overwrite").save("hdfs://localhost:50000/ProjectReal/Project3/orc")
   // val data2= spark.read.format("csv").schema(schema).option("header",true).load(input)
spark.sql("create database if not exists Air ")
   if(!spark.catalog.tableExists("Air","AirPollutation")) {

     data.withColumn("date", concat(month(col("utc")).cast("Int") <= 6, lit("~"), date_format(col("utc"), "MM-dd-yyyy"))).as("date").write.mode("overwrite").format("orc").bucketBy(4, "date", "city").saveAsTable("Air.AirPollutation")
   }
    data.show


    spark.sql("select date, city, collect_list(parameter),collect_list(value) from Air.Airpollutation group by date, city").show

    val toxicRateFind= udf(toxicRateFinder(_ :  List[String], _ : List[Double]): Integer)
    spark.udf.register("toxicRateFind",toxicRateFind)


    spark.sql("""select avg(toxicValueperDay) as toxicRate, date,city from(select concat(split(split(date,"~")[1],"-")[2],"-",if(split(date,"~")[0]==true,1,2)) as date, city, toxicRateFind(collect_list(parameter),collect_list(value)) as toxicValuePerDay from Air.Airpollutation group by date, city) group by date, city order by toxicRate """).write.mode("overwrite").format("csv").save(output)
  }
  def ppmTovolumeConver(value: Double):BigDecimal={
    var con=0.00086956521
    return con*value;
  }
  def toxicRateFinder(parameter:List[String], value:List[Double] ):Integer= {
    var toxicOrder = Map("so2" -> 1, "co" -> 2, "o3" -> 4, "pm10" -> 5, "no2" -> 3, "pm25" -> 5)
    var finTR = 0;
    for (x <- 0 to parameter.size-1) {

      val str=parameter(x)
      val unit= value(x)

      str match {
        case "so2"=> if(unit<=ppmTovolumeConver(0.1)){
          finTR=finTR+toxicOrder("so2")+0;
        }

        else if(unit>ppmTovolumeConver(0.2) && unit<ppmTovolumeConver(5)){
          finTR=finTR+toxicOrder("so2")+1;

        }
        else{
          finTR=finTR+toxicOrder("so2")+2;

        }
        case "pm10"=>
          if(unit<54){
            finTR=finTR+toxicOrder("pm10")+0;

          }else{
            finTR=finTR+toxicOrder("pm10")+2;

          }
        case "co"=>
          if(unit<=ppmTovolumeConver(9)){
            finTR=finTR+toxicOrder("co")+0;
          }

          else if(unit>ppmTovolumeConver(10) && unit<ppmTovolumeConver(29)){
            finTR=finTR+toxicOrder("co")+1;

          }
          else{
            finTR=finTR+toxicOrder("co")+2;

          }
        case "no2"=>
          if(unit<=ppmTovolumeConver(7200)) {
            finTR = finTR + toxicOrder("no2") + 0;
          }
          else{
            finTR=finTR+toxicOrder("no2")+2;

          }
        case "o3"=>
          if(unit<=ppmTovolumeConver(0.075)){
            finTR=finTR+toxicOrder("o3")+0;
          }

          else if(unit>ppmTovolumeConver(0.076) && unit<ppmTovolumeConver(0.05)){
            finTR=finTR+toxicOrder("o3")+1;

          }
          else{
            finTR=finTR+toxicOrder("o3")+2;

          }
        case "pm25"=>

          if(unit<=12){
            finTR=finTR+toxicOrder("pm25")+0;
          }

          else if(unit>13 || unit<45){
            finTR=finTR+toxicOrder("pm25")+1;

          }
          else{
            finTR=finTR+toxicOrder("pm25")+2;

          }
      }



    }





    return finTR;
  }

}
