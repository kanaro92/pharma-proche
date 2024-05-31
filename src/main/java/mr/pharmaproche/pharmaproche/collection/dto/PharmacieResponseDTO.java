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
public class PharmacieResponseDTO {

    private String id;
    private Double price;
    private Boolean availability;
    private LocalDateTime createdAt;
    private String userRequestId;
    private String pharmacieId;

}
