package mr.pharmaproche.pharmaproche.service;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.UserRequest;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import mr.pharmaproche.pharmaproche.mapper.UserRequestMapper;
import mr.pharmaproche.pharmaproche.repository.UserRequestRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserRequestServiceImpl implements UserRequestService{

    private final UserRequestRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final UserRequestMapper userRequestMapper;

    public UserRequestServiceImpl(UserRequestRepository repository, KafkaTemplate<String, Object> kafkaTemplate, UserRequestMapper userRequestMapper) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.userRequestMapper = userRequestMapper;
    }


    @Override
    public String searchMedicament(UserRequest userRequest) {
        String requestId =  repository.save(userRequest).getId();
        UserRequestDTO dto =  userRequestMapper.userRequestToDTO(repository.findById(requestId).get());
        publishEvent(dto);
        return requestId;
    }

    @Override
    public List<UserRequest> getUserRequestByUserId(String userId) {
        return repository.findUserRequestByUserId(userId);
    }

    private void publishEvent(UserRequestDTO userRequest) {
        kafkaTemplate.send(AppConstant.USER_REQUEST_TOPIC, userRequest);
    }

    @KafkaListener(topics = AppConstant.USER_REQUEST_TOPIC, groupId = "user-request-group")
    public void listenUserRequestTopic(UserRequestDTO userRequest) {
        log.info("Received message: {}", userRequest);
    }
}
