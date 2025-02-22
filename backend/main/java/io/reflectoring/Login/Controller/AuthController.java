/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.reflectoring.Login.Controller;
 
import io.reflectoring.Login.Entity.AuthRequest;
import io.reflectoring.Login.Entity.LoginResponse;
import io.reflectoring.Login.Entity.RegisterRequest; 
import org.springframework.web.bind.annotation.*;
 import io.reflectoring.Login.Service.AuthService;
/**
 *
 * @author uday enter
 */  
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthRequest request) {
        return authService.loginUser(request);
    }
}

//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//   @PostMapping("/register")
//public String register(@RequestBody RegisterRequest request) {
//    if (request.getRoles() == null || request.getRoles().isEmpty()) {
//        request.setRoles(Set.of("USER")); // Default role if not provided
//    }
//    
//    System.out.println("New user: " + request.getUsername() + " Role: " + request.getRoles());
//    return "User registered successfully";
//}
//    @PostMapping("/login")
//    public String login(@RequestBody AuthRequest request) {
//        // Perform authentication and return token
//        return "Login successful";
//
//    }
//}