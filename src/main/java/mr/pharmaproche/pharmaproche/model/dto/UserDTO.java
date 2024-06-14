package mr.pharmaproche.pharmaproche.model.dto;

import lombok.*;
import mr.pharmaproche.pharmaproche.model.Role;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Role role;
    private AddressDTO address;
    private List<UserRequestDTO> userRequests;
}
