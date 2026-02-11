package letters.repository;

import letters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByLogin(String login);
    Optional<User> findByLogin(String login);
}
