package letters.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String name;
    private String password;
    private String email;
    @OneToMany
    private List<Letter> letters = new ArrayList<>();
}
