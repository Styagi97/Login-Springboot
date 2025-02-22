package io.reflectoring.Login.Repository;

import io.reflectoring.Login.Entity.User; 
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uday enter
 */ 
public interface UserRepository  extends JpaRepository<User,Long>{
    
     Optional<User> findByEmail(String email);
}
