package emsi.ma.jparole.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "USERS")
public class User {
    @Id
    private String id ;
    @Column(name = "USER_NAME",unique = true , length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;
    @ManyToMany(mappedBy = "users" , fetch = FetchType.EAGER)
    //@JoinTable(name = "USERS_ROLES")
    private List<Role> roles = new ArrayList<>();
}
