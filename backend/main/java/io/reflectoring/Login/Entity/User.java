/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.reflectoring.Login.Entity;
 
import java.util.Set;
import jakarta.persistence.*; 
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author uday enter
 */ 
@Entity
@Table(name = "user_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;
}
//@Entity 
//@Table(name = "user_Table") 
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
// 
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//    private String email;
//    private String password;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "role")
//    private Set<String> roles;
//
//    public Set<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<String> roles) {
//        this.roles = roles;
//    }
//    
//}