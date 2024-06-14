package mr.pharmaproche.pharmaproche.service;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.model.PharmacieResponse;
import mr.pharmaproche.pharmaproche.model.dto.PharmacieResponseDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import mr.pharmaproche.pharmaproche.mapper.PharmacieResponseMapper;
import mr.pharmaproche.pharmaproche.publisher.PharmacieResponsePublisher;
import mr.pharmaproche.pharmaproche.repository.PharmacieResponseRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PharmacieResponseServiceImpl implements PharmacieResponseService {

    private final PharmacieResponseRepository repository;
    private final PharmacieResponseMapper mapper;
    private final PharmacieResponsePublisher responsePublisher;

    public PharmacieResponseServiceImpl(PharmacieResponseRepository repository, PharmacieResponseMapper mapper, PharmacieResponsePublisher responsePublisher) {
        this.repository = repository;
        this.mapper = mapper;
        this.responsePublisher = responsePublisher;
    }

    @Override
    public List<PharmacieResponse> getPharmacieResponses() {
        return repository .findAll();
    }

    @Override
    public Long save(PharmacieResponse pharmacieResponse) {
        Long responseId = repository.save(pharmacieResponse).getId();
        PharmacieResponseDTO responseDTO = mapper.pharmacieResponseToDTO(repository.findById(responseId).get());
        responsePublisher.publish(responseDTO);
        return responseId;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<PharmacieResponse> getPharmacieResponseByUserRequestId(Long userRequestId) {
        return repository.findPharmacieResponseByUserRequestId(userRequestId);
    }

    @KafkaListener(topics = AppConstant.PHARMACIE_RESPONSE_TOPIC, groupId = "user-request-group")
    public void listenPharmacieResponseTopic(PharmacieResponseDTO response) {
        log.info("Received message: {}", response);
    }
}
