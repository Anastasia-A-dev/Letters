package letters.services.impl;

import letters.models.User;
import letters.repository.InMemoryUserDAO;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryUserServiceImpl implements UserService {
    private final InMemoryUserDAO repository;
    @Override
    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    @Override
    public void saveUser(User user) {
        repository.saveUser(user);
    }

    @Override
    public User findUserByLogin(String login) {
        return repository.findUserByLogin(login);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(String login) {
        repository.deleteUser(login);
    }
}
