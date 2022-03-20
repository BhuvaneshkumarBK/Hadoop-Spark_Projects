package Producers;

import com.acme.avro.Twittr;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import static Producers.prod.jsonTOAvroParser;


public class prodThred implements Runnable{
     KafkaProducer<String , Twittr> kpro;
     String line;
    prodThred(String line, KafkaProducer<String , Twittr> kpro){
        this.line=line;
        this.kpro=kpro;

    }

    @Override
    public void run() {
        if(!line.isEmpty()){
            JSONObject json = new JSONObject(line);
  System.out.println(line);

            Twittr.Builder d= Twittr.newBuilder();
            Twittr finalData = jsonTOAvroParser( json.getJSONObject("data"));
  try {
      kpro.send(new ProducerRecord<>(appConf.topic,finalData.getData().getId().toString(),finalData));

  }
  catch (Exception e){
      e.printStackTrace();
  }

        }
    }




}
