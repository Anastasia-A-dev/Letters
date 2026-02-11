package letters.services.impl;

import letters.models.Letter;
import letters.repository.LetterRepository;
import letters.services.LetterService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LetterServiceImpl implements LetterService {
    private final LetterRepository repository;
    @Override
    public List<Letter> findAllLetters() {
        return repository.findAll();
    }

    @Override
    public Letter saveLetter(Letter letter) {
        return repository.save(letter);
    }

    @Override
    public List<Letter> findByUser(Long userId) {
        return List.of();
    }

    @Override
    public void deleteLetter(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Letter> findById(Long id) {
        return List.of();
    }
}
