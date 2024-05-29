package mr.pharmaproche.pharmaproche.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "medicament")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Medicament {

    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private Double price;

}
