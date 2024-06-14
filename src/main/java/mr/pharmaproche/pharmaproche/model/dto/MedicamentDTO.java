package mr.pharmaproche.pharmaproche.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;

}
