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
public class PharmacieResponseDTO {

    private Long id;
    private Double price;
    private Boolean availability;
    private LocalDateTime createdAt;
    private PharmacieDTO pharmacie;
    private UserRequestDTO userRequest;

}
