package letters.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class User {
    private String id;
    @NonNull
    private String login;
    private String name;
    private String password;
    private String email;
}
