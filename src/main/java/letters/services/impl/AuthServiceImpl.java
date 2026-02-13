package letters.services.impl;

import letters.security.JwtConfig;
import letters.dto.AuthRequest;
import letters.dto.AuthResponse;
import letters.dto.RegisterRequest;
import letters.dto.RegisterResponce;
import letters.models.User;
import letters.services.AuthService;
import letters.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    @Override
    public RegisterResponce register(RegisterRequest request){
        if (userService.findUserByLogin(request.getLogin()).isPresent()){
            throw new RuntimeException("Login already exists");
        }
        User user = new User();
        user.setLogin(request.getLogin());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.saveUser(user);
        UserDetails userDetails = userService.loadUserByUsername(user.getLogin());
        String token = jwtConfig.generateToken(userDetails);
        return new RegisterResponce(token, userDetails.getUsername());
    }
    @Override
    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        String token = jwtConfig.generateToken(userService.loadUserByUsername(request.getLogin()));
        return new AuthResponse(token);
    }
}
