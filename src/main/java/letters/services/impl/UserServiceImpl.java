package letters.services.impl;

import letters.models.User;
import letters.repository.UserRepository;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
    @Override
    public Optional<User> findUserByLogin(String login) {
        return repository.findByLogin(login);
    }
    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(String login) {
        repository.deleteByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities("ROLE_USER")
                .build();
    }

}
