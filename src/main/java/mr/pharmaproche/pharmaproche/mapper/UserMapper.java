package mr.pharmaproche.pharmaproche.mapper;

import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private AddressMapper addressMapper;

    public UserDTO userToDTO(AppUser user) {
        if(user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole())
                .address(addressMapper.addressToDTO(user.getAddress()))
                .build();
    }

    public AppUser dtoToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        return AppUser.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .address(addressMapper.dtoToAddress(userDTO.getAddress()))
                .build();
    }

    public List<UserDTO> usersToDTOs(List<AppUser> users) {
        return users.stream().map(this::userToDTO).collect(Collectors.toList());
    }

    public List<AppUser> dtosToUsers(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::dtoToUser).collect(Collectors.toList());
    }
}
