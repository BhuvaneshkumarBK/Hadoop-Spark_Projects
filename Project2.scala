import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

import java.util.Properties

object Project2 {
  def main(args: Array[String]): Unit = {


    //input Path
    val input = "hdfs://localhost:50000/in*"
    //out Path
    val output = ""
    val url=    "jdbc:mysql://localhost:3306/Comply"

    //Creating Session
    val spark: SparkSession = SparkSession.builder()
      .appName("LoadDataToMySql.com")
      .getOrCreate()

    //implicits import
    import spark.implicits._
    //broadCast join
    spark.conf.set("spark.sql.autoBroadcastJoinThreshold",73400320)
    //job
    val comp = spark.read.format("parquet").load(input)
    val nonDuplicate = comp.na.drop("Any").repartition(16)
    nonDuplicate.persist();
    spark.sql("create database if not exists compliant").show
    println("----------------------"+spark.catalog.tableExists("compliant", "product")+"_____________________")
    if(!spark.catalog.tableExists("compliant", "product")) {
      nonDuplicate.select(get_json_object(col("value"), "$.product").as("product"), get_json_object(col("value"), "$.sub_product").as("sub_product"))
        .write.mode("overwrite").bucketBy(2, "product", "sub_product").saveAsTable("Compliant.product")
    }
    if(!spark.catalog.tableExists("compliant", "issue")) {
      nonDuplicate.select(get_json_object(col("value"), "$.issue").as("issue"), get_json_object(col("value"), "$.sub_issue").as("sub_issue"))
        .write.mode("overwrite").bucketBy(2, "issue").saveAsTable("Compliant.issue")
    }
    if(!spark.catalog.tableExists("compliant", "company")) {
     nonDuplicate.select(get_json_object(col("value"), "$.company").as("company"), get_json_object(col("value"), "$.state").as("state")
       , get_json_object(col("value"), "$.zip_code").as("zip_code")).write.bucketBy(2, "company", "zip_code", "state").saveAsTable("Compliant.company")
   }
    if(!spark.catalog.tableExists("compliant", "compliance")) {
      nonDuplicate.select(get_json_object($"value", "$.date_received").as("date_received"), get_json_object($"value", "$.date_sent_to_company").as("date_sent_to_company"),
        get_json_object($"value", "$.complaint_what_happened").as("complaint_what_happened"), get_json_object($"value", "$.tags").as("tags"), get_json_object($"value", "$.submitted_via").as("submitted_via"), get_json_object($"value", "$.issue").as("issue"), get_json_object($"value", "$.sub_issue").as("sub_issue"), get_json_object($"value", "$.product").as("product"), get_json_object($"value", "$.sub_product").as("sub_product"), get_json_object($"value", "$.company_response").as("company_response"), get_json_object($"value", "$.consumer_consent_provided").as("consumer_consent_provided"), get_json_object($"value", "$.timely").as("timely"), get_json_object($"value", "$.consumer_disputed").as("consumer_disputed"), get_json_object($"value", "$.complaint_id").as("complaint_id"), get_json_object($"value", "$.company_public_response").as("company_public_response"), get_json_object($"value", "$.company").as("company"), get_json_object($"value", "$.state").as("state"), get_json_object($"value", "$.zip_code").as("zip_code")).write.mode("overwrite").bucketBy(8, "date_received").saveAsTable("Compliant.compliance")
    }
    spark.sql("use compliant")
    val product=spark.sql("""select *,monotonically_increasing_id()+1 as Product_Id from(select distinct(*)  from product) """)
    val issue=spark.sql("""select * , monotonically_increasing_id()+1 as Issue_Id  from(select distinct(*) from issue) """)
    val company=spark.sql("""select  monotonically_increasing_id()+1 as company_Id , company as company_name, state, if(zip_code is null,"NA",zip_code) as zip_code from(select distinct(*) from company) """)

    val complaince=spark.sql("""select * from compliance """)

    val complianceTb=complaince.join(company,company("company_name")===complaince("company") and company("state")===complaince("state") and company("zip_code")===complaince("zip_code"),"inner").join(product,product("product")===complaince("product") and product("sub_product")===complaince("sub_product"),"inner").join(issue,issue("issue")===complaince("issue") and issue("sub_issue")===complaince("sub_issue"),"inner").select(col("date_received")
      .as("date_rcvd"),col("submitted_via").as("sbmt_via"),col("date_sent_to_company").as("dte_sent")
      ,col("complaint_what_happened").as("cmp_wht_hppn"),col("tags"),col("product_id"),col("company_id"),col("issue_id")
      ,col("company_response").as("com_rsp"),col("consumer_consent_provided").as("consu_const"),col("timely"),col("consumer_disputed").as("cons_disp"), col("company_public_response").as("pub_resp"),col("complaint_id"))


    var prop = new Properties()

  //  complianceTb.show()
   prop= new Properties()
    prop.put("user","bhuvanesh")
    prop.put("password","Bhuvi")



    product.write.mode("overwrite").option("batchsize", 100000).jdbc(url,"product",prop)
    issue.write.mode("overwrite").jdbc(url,"issue",prop)
    company.write.mode("overwrite").jdbc(url,"company",prop)
    complianceTb.write.mode("overwrite").jdbc(url,"complianceTb",prop)








  }

}
