package mr.pharmaproche.pharmaproche.service;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.PharmacieResponse;
import mr.pharmaproche.pharmaproche.collection.dto.PharmacieResponseDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import mr.pharmaproche.pharmaproche.mapper.PharmacieResponseMapper;
import mr.pharmaproche.pharmaproche.repository.PharmacieResponseRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PharmacieResponseServiceImpl implements PharmacieResponseService {

    private final PharmacieResponseRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final PharmacieResponseMapper mapper;

    public PharmacieResponseServiceImpl(PharmacieResponseRepository repository, KafkaTemplate<String, Object> kafkaTemplate, PharmacieResponseMapper mapper) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<PharmacieResponse> getPharmacieResponses() {
        return repository .findAll();
    }

    @Override
    public String save(PharmacieResponse pharmacieResponse) {
        String responseId = repository.save(pharmacieResponse).getId();
        PharmacieResponseDTO responseDTO = mapper.pharmacieResponseToDTO(repository.findById(responseId).get());
        publishEvent(responseDTO);
        return responseId;
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public List<PharmacieResponse> getPharmacieResponseByUserRequestId(String userRequestId) {
        return repository.findPharmacieResponseByUserRequestId(userRequestId);
    }

    private void publishEvent(PharmacieResponseDTO response) {
        kafkaTemplate.send(AppConstant.PHARMACIE_RESPONSE_TOPIC, response);
    }

    @KafkaListener(topics = AppConstant.PHARMACIE_RESPONSE_TOPIC, groupId = "user-request-group")
    public void listenPharmacieResponseTopic(PharmacieResponseDTO response) {
        log.info("Received message: {}", response);
    }
}
