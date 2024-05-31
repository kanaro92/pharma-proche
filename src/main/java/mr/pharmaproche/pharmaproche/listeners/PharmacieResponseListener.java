package mr.pharmaproche.pharmaproche.listeners;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.dto.PharmacieResponseDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PharmacieResponseListener {

    @KafkaListener(topics = AppConstant.PHARMACIE_RESPONSE_TOPIC, groupId = "user-request-group")
    public void listenPharmacieResponse(ConsumerRecord<String, PharmacieResponseDTO> record) {
        log.info("*********** New pharmacie response: {} ", record.value());
    }
}
