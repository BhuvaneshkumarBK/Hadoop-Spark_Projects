# Hadoop-Spark_Projects
END-END


Project#1
    • From article dataset which is stored in mysql and sqlite, tried to transfer into HDFS 
    • Transformation: stored all the values in DF and joined based on critea and stored based on Published time (partion by) in HDFS
    • Created pipeline single node (local) and perfomed tranfomation to store in HDFS
    
    
Project#2
    • From compliance single dataset , tried to segregate based on the sub topics(compliance, companye etc,.) then stored in mysql as seperate tables 
    • Created pipleine single node (local) and perfomed tranfomation to stores in mysql based on the criteria
    
    
Project#3 
    • From airpollution data, tried to find the state/area which has highest pollution rate on every 6 month 
    • Created pipleine single node (local) and moved to data to Aws and perfomed tranfomation then stored in S3
    • Wrote UDF to find pollution rate(level) of the chemicals in atmosphere eg: SO2, No2 etc,.
    
 Youtube Trending:
   every ten days.. find top 3 rank of trending category...channel that has most frequent(per month) trending count for 12 month on tht top 3
   
 Kafka#4
   Created Producer to fetch data using Twitter api and send as avro serialized Java object which is created using Pojo.
   Created consumer to consumer data from the topic, deserilized using custom avro serdes then filtered the data by language ('en'), grouped by hashtags  in every conversation(tweet) and counted. This group by data windowed by 30 min, advanced by 1 min and grace for 3 min so that lastest ( last 30 min) trending hashtags for every 1min can be found. Then it sent to another kafka topic, again it's processed to find top 10 trending hashtags using spark streaming api.
    
