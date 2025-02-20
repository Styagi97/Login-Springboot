/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.reflectoring.Login.Entity;

/**
 *
 * @author uday enter
 */
import java.util.Set;
import lombok.Data;
@Data
public class LoginResponse {
    private String message;
    private String token;
    private Set<String> roles;

    public LoginResponse(String message, String token, Set<String> roles) {
        this.message = message;
        this.token = token;
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
