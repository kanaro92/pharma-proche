package mr.pharmaproche.pharmaproche.publisher;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRequestPublisher implements EventPublisher<UserRequestDTO> {

    @Autowired
    KafkaTemplate<String, UserRequestDTO> kafkaTemplate;

    @Override
    public void publish(UserRequestDTO request) {
        kafkaTemplate.send(AppConstant.USER_REQUEST_TOPIC, request);
        log.info("*********** User request Published: {} ***********", request);
    }
}
