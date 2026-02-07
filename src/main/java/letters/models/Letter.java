package letters.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Builder
public class Letter {
    private Long id;
    private String title;
    private String text;
    private Long userId;
    private LocalDateTime createDate;
    private LocalDateTime sentDate;
}
