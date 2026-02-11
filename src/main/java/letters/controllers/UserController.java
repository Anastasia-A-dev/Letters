package letters.controllers;

import letters.models.User;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }
    @PostMapping()
    public void saveUser(@RequestBody User user) {
        service.saveUser(user);
    }
    @GetMapping("/{login}")
    public Optional<User> findUserByLogin(@PathVariable String login) {
        return service.findUserByLogin(login);
    }
    @PutMapping()
    public User updateUser(User user) {
        return service.updateUser(user);
    }
    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable String login) {
        service.deleteUser(login);
    }
}
