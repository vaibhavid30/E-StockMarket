package com.estockmarket.stockmarket.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.estockmarket.stockmarket.model.User;

import org.apache.kafka.common.serialization.StringSerializer;


@Configuration
@EnableKafka
public class KafkaProducerConfiguration {
	
	@Bean
    @ConditionalOnMissingBean
    public ProducerFactory<String, User> userProducerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, User>(config);
    }
	

    @Bean
    public KafkaTemplate<String, User> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
	
	
	//   @Bean public ProducerFactory<String, AirLine> airLineProducerFactory() {
	//   Map<String, Object> config = new HashMap<>();
	  
	//   config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	//   config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	//   StringSerializer.class);
	//   config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	//   JsonSerializer.class);
	  
	//   return new DefaultKafkaProducerFactory<String, AirLine>(config); }
	  
	  
	//   @Bean public KafkaTemplate<String, AirLine> airLineKafkaTemplate() { return
	//  new KafkaTemplate<>(airLineProducerFactory()); }
	 

}
