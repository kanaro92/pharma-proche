package mr.pharmaproche.pharmaproche.publisher;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.UserRequest;
import mr.pharmaproche.pharmaproche.collection.dto.PharmacieResponseDTO;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PharmacieResponsePublisher implements EventPublisher<PharmacieResponseDTO> {

    @Autowired
    KafkaTemplate<String, PharmacieResponseDTO> kafkaTemplate;

    @Override
    public void publish(PharmacieResponseDTO response) {
        kafkaTemplate.send(AppConstant.PHARMACIE_RESPONSE_TOPIC, response);
        log.info("*********** Pharmacie response published: {} ", response);
    }
}
