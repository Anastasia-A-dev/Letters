package letters.dto;

import letters.models.Letter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LetterResponse {
    private Long id;
    private String title;
    private String text;
    private LocalDateTime createDate;
    private LocalDateTime sentDate;

    public LetterResponse(Letter letter){
        this.id = letter.getId();
        this.title = letter.getTitle();
        this.text = letter.getText();
        this.createDate = letter.getCreateDate();
        this.sentDate = letter.getSentDate();
    }

}
