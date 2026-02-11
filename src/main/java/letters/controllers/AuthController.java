package letters.controllers;

import letters.dto.AuthRequest;
import letters.dto.RegisterRequest;
import letters.models.User;
import letters.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){
        return service.register(request);
    }
    @PostMapping("/login")
    public User login(@RequestBody AuthRequest request){
        return service.login(request);
    }

}
