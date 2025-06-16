package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class KaProducer {

    public static void main(String[] args) { 

        // 创建 Properties 对象,存储 Kafka 配置
        Properties kaProperties = new Properties();

        // 设置 Kafka 服务器的地址
        kaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");

        // 设置键序列号器为字符串类型
        kaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 值序列号器为字符串类型
        // kaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        // JsonSerializer.class.getName());
        kaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        /**
         * acks 配置参数用于控制生产者发送消息时的确认机制。
         * 它可以设置为以下值：
         * 0：表示生产者不需要等待任何确认，消息发送后立即返回。这种方式速度最快，但可能会丢失消息。
         * 1：表示生产者需要等待分区的首领副本（leader）确认消息已写入。这种方式提供了一定的可靠性。
         * all（或 -1）：表示生产者需要等待所有副本确认消息已写入。这种方式提供最高的可靠性，但延迟较高。
         */
        kaProperties.put(ProducerConfig.ACKS_CONFIG, "0");

        // 重试次数
        kaProperties.put(ProducerConfig.RETRIES_CONFIG, "3"); 

        /*
         * MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION 是 kafka 生产者配置参数。
         * 它用于限制每个连接中可以同时发送但尚未收到相应的请求数量。
         * 如果设置为1，能保证消息按顺序写入分区。
         * 在启用幂等性或事务时，这个值强制设为1，有助于确保消息的顺序和事务一致性。
         * 如果大于1，可能出现乱序写入，但能提升吞吐量。
         * 
         * 未完成的请求数量超过这个值时，生产者会阻塞等待，直到有请求完成。
         * 这个参数的默认值是5。
         */
        kaProperties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);

        // 创建Kafka生产者并使用之前设置的配置属性
        try (Producer<String, String> producer = new KafkaProducer<>(kaProperties)) {

            Order order = Order.builder()
                    .id(1L)
                    .name("order1")
                    .orderDate(java.time.LocalDateTime.now())
                    .build();

            // 创建一个ProducerRecord对象，指定主题和消息内容
            /*
             * ProducerRecord 是 Kafka 生产者发送消息的重要组件。
             * 它用于指定消息发送的目标主题，这决定了消息的基本流向。
             * 可以设定分区，能精准控制消息存储分区，若不指定，Kafka 会按策略分配。
             * 其中的键能够用于分区分配，确保相关消息在同一分区。
             * 时间戳记录消息产生时间，方便后续时间相关处理。
             */
            ProducerRecord<String, Order> producerRecord = new ProducerRecord<>("topic", "id", order);

            // 发送消息
            // 发送ProducerRecord对象，并同步获取发送结果
            producer.send(producerRecord).get();

        }

    }

    public static class JsonSerializer implements org.apache.kafka.common.serialization.Serializer<Order> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, Order data) {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                log.error("Error serializing JSON message", e);
                throw new RuntimeException("Error serializing JSON message", e);
            }
        }
    }

}
