package consumers;

import CustomeSerdes.AppSerdes;
import Producers.appConf;
import TimeStampWindow.CustomeTimeWindow;
import com.acme.avro.Twittr;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.util.*;

public class cons {
    public static void main(String[] args) {
        Properties stProp= new Properties();
        stProp.put(StreamsConfig.APPLICATION_ID_CONFIG,appConf.clienID);
        stProp.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, appConf.BOOTSTRAP_SERVERS_CONFIG);
        stProp.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, AppSerdes.String().getClass().getName());
        stProp.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AppSerdes.twitterSerde().getClass().getName());
        stProp.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, false);
        stProp.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://localhost:8081");
        //   stProp.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class);
        stProp.put(StreamsConfig.STATE_DIR_CONFIG,"store2");
        stProp.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,0);
        Map<String,String> changeLogConf= new HashMap<>();
        changeLogConf.put("min.insync.replicas","1");


        StreamsBuilder stream= new StreamsBuilder();
       AppTopology.builder(stream);

        Topology topy = stream.build();
        KafkaStreams finalSt= new KafkaStreams(topy,stProp);

        finalSt.start();
        Runtime.getRuntime().addShutdownHook(new Thread(finalSt::close));
    }
}


