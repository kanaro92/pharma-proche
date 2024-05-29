package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.collection.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private AddressMapper addressMapper;

    public UserDTO userToDTO(User user) {
        if(user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getUserRole())
                .address(addressMapper.addressToDTO(user.getAddress()))
                .build();
    }

    public User dtoToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .userRole(userDTO.getRole())
                .address(addressMapper.dtoToAddress(userDTO.getAddress()))
                .build();
    }

    public List<UserDTO> usersToDTOs(List<User> users) {
        return users.stream().map(this::userToDTO).collect(Collectors.toList());
    }

    public List<User> dtosToUsers(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::dtoToUser).collect(Collectors.toList());
    }
}
