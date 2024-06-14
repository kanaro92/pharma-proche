package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.model.UserRequest;
import mr.pharmaproche.pharmaproche.model.dto.UserRequestDTO;
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
                .user(userMapper.userToDTO(userRequest.getUser()))
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
                .user(userMapper.dtoToUser(userRequestDTO.getUser()))
                .createdAt(userRequestDTO.getCreatedAt())
                .build();
    }
}
