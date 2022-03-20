
package CustomeSerdes;


import com.acme.avro.Twittr;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;


public class AppSerdes extends Serdes {


    public static Serde<Twittr> twitterSerde() {
        Serde<Twittr> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", "http://localhost:8081");

        serde.configure(serdeConfigs, false);

        return serde;
    }






}
