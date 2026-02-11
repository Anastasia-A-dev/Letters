package letters.controllers;

import letters.models.Letter;
import letters.services.LetterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/letters")
@AllArgsConstructor
public class LetterController {
    private final LetterService service;
    @GetMapping()
    public List<Letter> findAllLetters() {
        return service.findAllLetters();
    }
    @PostMapping()
    public Letter saveLetter(Letter letter) {
        return service.saveLetter(letter);
    }
    public List<Letter> findByUser( Long userId) {
        return service.findByUser(userId);
    }
    @GetMapping("/{id}")
    public List<Letter> findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @DeleteMapping()
    public void deleteLetter(Long id) {
        service.deleteLetter(id);
    }
}
