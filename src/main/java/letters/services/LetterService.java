package letters.services;

import letters.models.Letter;

import java.util.List;

public interface LetterService {
    List<Letter> findAllLetters();
    Letter saveLetter(Letter letter);
    List<Letter> findByUser(Long userId);
    void deleteLetter(Long id);

}
