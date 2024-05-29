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
@Document(collection = "user_request")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    @Id
    private String id;
    private String medicament;
    private String latitude;
    private String longitude;
    private LocalDateTime createdAt;
    @DocumentReference
    private User user;

}
