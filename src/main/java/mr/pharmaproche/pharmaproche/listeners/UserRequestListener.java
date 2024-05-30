package mr.pharmaproche.pharmaproche.listeners;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRequestListener {

    @KafkaListener(topics = AppConstant.USER_REQUEST_TOPIC, groupId = "user-request-group")
    public void listenUserRequestTopic(ConsumerRecord<String, UserRequestDTO> record) {
        log.info("*********** New user request: {} ", record.value());
    }
}
