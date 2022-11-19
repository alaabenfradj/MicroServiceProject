package school.micro.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id ;
    private String firstName ;
    private String lastName ;
    private String userName ;
    private String email ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;
    private int phone ;
    @DBRef
    private Collection<Role> roles =new ArrayList<>() ;


}
