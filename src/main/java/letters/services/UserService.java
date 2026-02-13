package letters.services;

import letters.dto.AuthRequest;
import letters.dto.AuthResponse;
import letters.dto.RegisterRequest;
import letters.dto.RegisterResponce;
import letters.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> findAllUsers();
    User saveUser(User user);
    Optional<User> findUserByLogin(String login);
    User updateUser(User user);
    void deleteUser(String login);


}
