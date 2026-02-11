package letters.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="letters")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private LocalDateTime createDate;
    private LocalDateTime sentDate;
}
