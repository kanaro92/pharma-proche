package mr.pharmaproche.pharmaproche.collection.dto;

import lombok.*;
import mr.pharmaproche.pharmaproche.collection.enums.UserRole;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private UserRole role;
    private AddressDTO address;
    private String token;

}
