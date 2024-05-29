package mr.pharmaproche.pharmaproche.collection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDTO {

    private String id;
    private String name;
    private String description;
    private String category;
    private Double price;

}
