package letters.repository;

import letters.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemoryUserDAO {
    private final List<User> USERS = new ArrayList<>();
    public List<User> findAllUsers() {
        return USERS;
    }
    public void saveUser(User user) {
        USERS.add(user);
    }
    public User findUserByLogin(String login) {
        return USERS.stream()
                .filter(param -> param.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
    public User updateUser(User user) {
        var userIndx = IntStream.range(0, USERS.size())
                .filter(index -> USERS.get(index).getLogin().equals(user.getLogin()))
                .findFirst()
                .orElse(-1);
        if (userIndx != -1){
            USERS.set(userIndx, user);
            return user;
        }
        return null;
    }
    public void deleteUser(String login) {
        var user = findUserByLogin(login);
        if (login != null){
            USERS.remove(user);
        }
    }
}
