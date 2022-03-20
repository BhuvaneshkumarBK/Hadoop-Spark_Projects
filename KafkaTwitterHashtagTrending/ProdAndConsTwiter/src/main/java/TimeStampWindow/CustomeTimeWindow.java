package TimeStampWindow;

import com.acme.avro.Twittr;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.time.Instant;

public class CustomeTimeWindow implements TimestampExtractor{

    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long prevTime) {
        Twittr tweet= (Twittr) consumerRecord.value();
       Long event= Instant.parse(tweet.getData().getCreatedAt()).toEpochMilli();
       return event<0?prevTime:event;
    }
}
