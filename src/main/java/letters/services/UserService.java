package letters.services;

import letters.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void saveUser(User user);
    User findUserByLogin(String login);
    User updateUser(User user);
    void deleteUser(String login);

}
