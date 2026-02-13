package letters.controllers;

import letters.dto.AuthRequest;
import letters.dto.AuthResponse;
import letters.dto.RegisterRequest;
import letters.dto.RegisterResponce;
import letters.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public RegisterResponce register(@RequestBody RegisterRequest request){
        return service.register(request);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        return service.login(request);
    }

}
