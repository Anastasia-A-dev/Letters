package letters.services;

import letters.dto.AuthRequest;
import letters.dto.RegisterRequest;
import letters.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user);
    Optional<User> findUserByLogin(String login);
    User updateUser(User user);
    void deleteUser(String login);
    User register(RegisterRequest request);
    User login(AuthRequest request);

}
