package mr.pharmaproche.pharmaproche.collection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String id;
    private String medicament;
    private String latitude;
    private String longitude;
    private LocalDateTime createdAt;
    private UserDTO user;

}
