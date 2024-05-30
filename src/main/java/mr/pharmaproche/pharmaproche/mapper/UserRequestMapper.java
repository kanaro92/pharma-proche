package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.collection.UserRequest;
import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {

    @Autowired
    private UserMapper userMapper;

    public UserRequestDTO userRequestToDTO(UserRequest userRequest) {
        if(userRequest == null) {
            return null;
        }
        return UserRequestDTO.builder()
                .id(userRequest.getId())
                .medicament(userRequest.getMedicament())
                .latitude(userRequest.getLatitude())
                .longitude(userRequest.getLongitude())
                .userId(userRequest.getUserId())
                .userEmail(userRequest.getUserEmail())
                .createdAt(userRequest.getCreatedAt())
                .build();
    }

    public UserRequest dtoToUserRequest(UserRequestDTO userRequestDTO) {
        if(userRequestDTO == null) {
            return null;
        }
        return UserRequest.builder()
                .id(userRequestDTO.getId())
                .medicament(userRequestDTO.getMedicament())
                .latitude(userRequestDTO.getLatitude())
                .longitude(userRequestDTO.getLongitude())
                .userId(userRequestDTO.getUserId())
                .userEmail(userRequestDTO.getUserEmail())
                .createdAt(userRequestDTO.getCreatedAt())
                .build();
    }
}
