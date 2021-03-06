package vip.acheng.sea.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/8 14:01
 * @Description:
 */

@SpringBootTest
public class kafkaTest {

    @Autowired
    private kafkaProducer producer;

    @Test
    public void testKafka(){
        producer.sendMessage("test","la-sea");
        producer.sendMessage("test","hello world");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

@Component
class kafkaProducer{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic,String content){
        kafkaTemplate.send(topic,content);
    }

}

@Component
class kafkaConsumer{

    @KafkaListener(topics = {"test"})
    public void handleMessage(ConsumerRecord record){
        System.out.println(record.value().toString());
    }
}
