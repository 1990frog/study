package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KaProducer {

    public static void main(String[] args) { 

        // 创建 Properties 对象,存储 Kafka 配置
        Properties kaProperties = new Properties();

        // 设置 Kafka 服务器的地址
        kaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");

        // 设置键序列号器为字符串类型
        kaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 值序列号器为字符串类型
        kaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"" );

        // 设置消息确认机制
        kaProperties.put(ProducerConfig.ACKS_CONFIG, "0");

        // 重试次数
        kaProperties.put(ProducerConfig.RETRIES_CONFIG, "3"); 

        /*
         * MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION 是 kafka 生产者配置参数。
         * 它用于限制每个连接中可以同时发送但尚未收到相应的请求数量。
         * 如果设置为1，能保证消息按顺序写入分区。
         * 在启用幂等性或事务时，这个值强制设为1，有助于确保消息的顺序和事务一致性。
         * 如果大于1，可能出现乱序写入，但能提升吞吐量。
         */
        kaProperties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);

        // 创建Kafka生产者并使用之前设置的配置属性
        try (Producer<String, String> producer = new KafkaProducer<>(kaProperties)) {

            // 创建一个ProducerRecord对象，指定主题和消息内容
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<>("topic", "hello world again!");

            // 发送消息
            producer.send(producerRecord);

        }

    }

}
