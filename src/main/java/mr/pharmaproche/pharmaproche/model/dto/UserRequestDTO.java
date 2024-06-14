package mr.pharmaproche.pharmaproche.model.dto;

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

    private Long id;
    private String medicament;
    private String latitude;
    private String longitude;
    private LocalDateTime createdAt;
    private UserDTO user;

}
