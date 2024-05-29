package mr.pharmaproche.pharmaproche.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pharmacie")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pharmacie {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private Address address;

}
