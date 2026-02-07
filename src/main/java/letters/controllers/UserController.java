package letters.controllers;

import letters.models.User;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }
    public void saveUser(User user) {
        service.saveUser(user);
    }
    public User findUserByLogin(String login) {
        return service.findUserByLogin(login);
    }
    public User updateUser(User user) {
        return service.updateUser(user);
    }
    public void deleteUser(String login) {
        service.deleteUser(login);
    }
}
