package mr.pharmaproche.pharmaproche.service;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.collection.UserRequest;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import mr.pharmaproche.pharmaproche.constant.AppConstant;
import mr.pharmaproche.pharmaproche.mapper.UserRequestMapper;
import mr.pharmaproche.pharmaproche.publisher.UserRequestPublisher;
import mr.pharmaproche.pharmaproche.repository.UserRequestRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserRequestServiceImpl implements UserRequestService{

    private final UserRequestRepository repository;
    private final UserRequestMapper userRequestMapper;
    private final UserRequestPublisher userRequestPublisher;

    public UserRequestServiceImpl(UserRequestRepository repository, UserRequestMapper userRequestMapper, UserRequestPublisher userRequestPublisher) {
        this.repository = repository;
        this.userRequestMapper = userRequestMapper;
        this.userRequestPublisher = userRequestPublisher;
    }


    @Override
    public String searchMedicament(UserRequest userRequest) {
        String requestId =  repository.save(userRequest).getId();
        UserRequestDTO dto =  userRequestMapper.userRequestToDTO(repository.findById(requestId).get());
        userRequestPublisher.publish(dto);
        return requestId;
    }

    @Override
    public List<UserRequest> getUserRequestByUserId(String userId) {
        return repository.findUserRequestByUserId(userId);
    }
}
