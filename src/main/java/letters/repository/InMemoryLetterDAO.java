package letters.repository;

import letters.models.Letter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryLetterDAO {
    private final List<Letter> LETTERS = new ArrayList<>();
    public List<Letter> findAllLetters() {
        return LETTERS;
    }
    public Letter saveLetter(Letter letter) {
        LETTERS.add(letter);
        return letter;
    }
    public List<Letter> findByUser(Long userId) {
        return LETTERS.stream().filter(param -> param.getUser().getId().equals(userId)).toList();
    }
    public List<Letter> findById(Long id) {
        return LETTERS.stream().filter(param -> param.getUser().getId().equals(id)).toList();
    }
    public void deleteLetter(Long id) {
        LETTERS.remove(findById(id));
    }
}
