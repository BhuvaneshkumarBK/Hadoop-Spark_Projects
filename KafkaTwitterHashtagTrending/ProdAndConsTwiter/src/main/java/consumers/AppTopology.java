package consumers;

import CustomeSerdes.AppSerdes;
import Producers.appConf;
import TimeStampWindow.CustomeTimeWindow;
import com.acme.avro.Twittr;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AppTopology {
    static void builder(StreamsBuilder stream){

        KStream<String, Twittr> ks1 = stream.stream(appConf.topic, Consumed.with(AppSerdes.String(), AppSerdes.twitterSerde()).withTimestampExtractor(new CustomeTimeWindow()));
        KTable<Windowed<String>, Long> finalVal = ks1.filter((k, v) -> (v.getData().getLang().toString().equals("en")))
                .flatMap((k, v) -> {
                    List<KeyValue<String, Integer>> tags = new ArrayList<>();
                    for (int l = 0; l < v.getData().getEntities().getHashtags().size(); l++) {
                        tags.add(new KeyValue<>(v.getData().getEntities().getHashtags().get(l).getTag()
                                .toString(), 1));
                    }


                    return tags;
                }).


                groupByKey(Grouped.with(AppSerdes.String(), AppSerdes.Integer()))
                .windowedBy(TimeWindows.of(Duration.ofMinutes(30))
                        .grace(Duration.ofMinutes(3))
                        .advanceBy(Duration.ofMinutes(1)))
                .count();
        finalVal.toStream().to(appConf.outTopic);



    }
}
