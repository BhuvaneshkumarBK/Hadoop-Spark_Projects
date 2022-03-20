package Producers;

import com.acme.avro.*;
import org.apache.http.HttpEntity;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.common.serialization.StringSerializer;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.json.JSONObject;

public class prod {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Properties prodProp= new Properties();
        prodProp.put(ProducerConfig.CLIENT_ID_CONFIG,appConf.clienID);
        prodProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,appConf.BOOTSTRAP_SERVERS_CONFIG);
        prodProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prodProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
       // prodProp.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,appConf.TRANSACTIONAL_ID_CONFIG);
        prodProp.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,appConf.schema);




        KafkaProducer<String , Twittr> kpro= new KafkaProducer(prodProp);
        twitterConnecter conn = new twitterConnecter();

        HttpEntity entity = conn.generatData();
        Thread [] dispacters= new Thread[3];
        if (null != entity) {
            BufferedReader reader = new BufferedReader(new InputStreamReader((entity.getContent())));
            String line = reader.readLine();

            try{
               //    kpro.initTransactions();
               //    kpro.beginTransaction();

                while (line != null ) {


                    dispacters[line.length()%2]= new Thread((new prodThred(line,kpro)));
                    dispacters[line.length()%2].start();



                    line = reader.readLine();
                }
                for (Thread t : dispacters) {
                    try {
                        t.join();

                    } catch (InterruptedException e) {
                        t.stop();
                      //  kpro.abortTransaction();
                    }
                }
              //  kpro.commitTransaction();
            }
            catch (Exception e){
                 // kpro.abortTransaction();
            }
            finally {
                kpro.close();
            }
        }


    }

    public static Twittr jsonTOAvroParser(JSONObject json){

        List<context_annotations_record> cars= new ArrayList<>();
        try{
            for(int l=0;l<json.getJSONArray("context_annotations").length();l++){

                JSONObject js=  json.getJSONArray("context_annotations").getJSONObject(l);

                domain dom= domain.newBuilder()
                        .setDescription(js.getJSONObject("domain").get("description").toString())
                        .setName(js.getJSONObject("domain").get("name").toString())
                        .setId(js.getJSONObject("domain").get("id").toString()).build();

                entity ent= entity.newBuilder().
                        setId(js.getJSONObject("entity").get("id").toString())
                        .setName(js.getJSONObject("entity").get("name").toString()).build();

                context_annotations_record car=context_annotations_record.newBuilder()
                        .setDomain(dom)
                        .setEntity(ent).build();
                cars.add(car);
            }

        }
        catch (Exception e){
        }

        List<hashtags_record> tags= new ArrayList<>();
        try{
            for(int l=0;l<json.getJSONObject("entities").getJSONArray("hashtags").length();l++) {
            JSONObject tgj=json.getJSONObject("entities").getJSONArray("hashtags").getJSONObject(l);
            hashtags_record tag=hashtags_record.newBuilder()
                    .setEnd(Integer.parseInt(tgj.get("end").toString()))
                    .setStart(Integer.parseInt(tgj.get("start").toString()))
                    .setTag(tgj.get("tag").toString())
                    .build();
            tags.add(tag);
        }

        }
        catch (Exception e){
        }
        List<mentions_record> mentions= new ArrayList<>();

try{
        for(int l=0;l<json.getJSONObject("entities").getJSONArray("mentions").length();l++) {
            JSONObject tgj=json.getJSONObject("entities").getJSONArray("mentions").getJSONObject(l);
            mentions_record mention=mentions_record.newBuilder()
                    .setEnd(Integer.parseInt(tgj.get("end").toString()))
                    .setStart(Integer.parseInt(tgj.get("start").toString()))
                    .setUsername(tgj.get("username").toString())
                    .setId(tgj.get("id").toString())
                    .build();
            mentions.add(mention);
        }}
catch (Exception e){

}

        entities mainEnt=entities.newBuilder().
                setHashtags(tags)
                .setMentions(mentions)
                .build();
       public_metrics publicM=public_metrics.newBuilder()
                .setLikeCount(Integer.parseInt(json.getJSONObject("public_metrics").get("like_count").toString()))
                .setQuoteCount(Integer.parseInt(json.getJSONObject("public_metrics").get("quote_count").toString()))
                .setReplyCount(Integer.parseInt(json.getJSONObject("public_metrics").get("reply_count").toString()))
                .setRetweetCount(Integer.parseInt(json.getJSONObject("public_metrics").get("retweet_count").toString()))
                .build();
       List<referenced_tweets_record> tweets= new ArrayList<>();
     try{
         for(int l=0;l<json.getJSONArray("referenced_tweets").length();l++) {
             JSONObject tgj=json.getJSONArray("referenced_tweets").getJSONObject(l);
             referenced_tweets_record tweet=referenced_tweets_record.newBuilder()
                     .setId(tgj.get("id").toString())
                     .setType(tgj.get("type").toString())
                     .build();
             tweets.add(tweet);
         }
     }
     catch (Exception e){

     }

        data d=data.newBuilder()
                .setAuthorId(json.get("author_id").toString())
                .setContextAnnotations(cars)
                .setConversationId(json.get("conversation_id").toString())
                .setCreatedAt(json.get("created_at").toString())
                .setEntities(mainEnt)
                .setGeo(geo.newBuilder().build())
                .setId(json.get("id").toString())
                .setLang(json.get("lang").toString())
                .setPossiblySensitive(Boolean.parseBoolean(json.get("possibly_sensitive").toString()))
                .setPublicMetrics(publicM)
                .setReferencedTweets(tweets)
                .setReplySettings(json.get("reply_settings").toString())
                .setSource(json.get("source").toString())
                .setText(json.get("text").toString()).build();
      return  Twittr.newBuilder().setData(d).build();

    }

}
