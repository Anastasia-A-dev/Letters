package letters.services.impl;

import io.jsonwebtoken.security.Jwks;
import letters.dto.AuthRequest;
import letters.dto.RegisterRequest;
import letters.models.User;
import letters.repository.UserRepository;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
    public User register(RegisterRequest request){
        if (findUserByLogin(request.getLogin()) == null){
            throw new RuntimeException("Login already exists");
        }
        User user = new User();
        user.setLogin(request.getLogin());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return repository.save(user);
    }

    @Override
    public User login(AuthRequest request) {
        Optional<User> userOpt = repository.findByLogin(request.getLogin());
        if (userOpt.isEmpty()){
            throw new RuntimeException("Invalid login");
        }
        User user = userOpt.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid login password");
        }
        return user;
    }

}
