 
package io.reflectoring.Login.Service;

import io.reflectoring.Login.Entity.AuthRequest;
import io.reflectoring.Login.Entity.LoginResponse;
import io.reflectoring.Login.Entity.User;
import io.reflectoring.Login.Repository.UserRepository;
import org.springframework.stereotype.Service;
import io.reflectoring.Login.Entity.RegisterRequest;
import io.reflectoring.Login.Security.JwtUtil; // Import JWT utility
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }           

    public String registerUser(RegisterRequest request) {
        System.out.println("RegisterRequest"+request);
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists!";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoles()); // Set roles from the request

        System.out.println("System.out.println"+request.getRoles());
        userRepository.save(user);
        return "User registered successfully!";
    }

 public LoginResponse loginUser(AuthRequest request) {
    System.out.println("loginUser" + request);
    Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
    if (userOpt.isPresent()) {
        User user = userOpt.get();
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return new LoginResponse("Login successful", token, user.getRoles());
        }
    }
    return new LoginResponse("Invalid credentials", null, null);
}
 
} 