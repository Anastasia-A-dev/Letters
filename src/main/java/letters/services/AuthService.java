package letters.services;

import letters.dto.AuthRequest;
import letters.dto.AuthResponse;
import letters.dto.RegisterRequest;
import letters.dto.RegisterResponce;

public interface AuthService {
    RegisterResponce register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
