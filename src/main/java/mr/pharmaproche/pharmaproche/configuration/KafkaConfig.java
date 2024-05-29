package mr.pharmaproche.pharmaproche.configuration;

import mr.pharmaproche.pharmaproche.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic userRequestTopic() {
        return TopicBuilder.name(AppConstant.USER_REQUEST_TOPIC).build();
    }

    @Bean
    public NewTopic PharmacieResponseTopic() {
        return TopicBuilder.name(AppConstant.PHARMACIE_RESPONSE_TOPIC).build();
    }
}

