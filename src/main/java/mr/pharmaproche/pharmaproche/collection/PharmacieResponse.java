package mr.pharmaproche.pharmaproche.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pharmacie_response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PharmacieResponse {

    @Id
    private String id;
    private Double price;
    private Boolean availability;
    private LocalDateTime createdAt;
    @DocumentReference
    private UserRequest userRequest;
    @DocumentReference
    private Pharmacie pharmacie;

}
