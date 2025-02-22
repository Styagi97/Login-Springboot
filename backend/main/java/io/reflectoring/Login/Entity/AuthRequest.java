  package io.reflectoring.Login.Entity;

    import lombok.Data;
    /**
     *
     * @author uday enter
     */
    @Data
    public class AuthRequest {

        private String email;
        private String password;
         private String role;
    }
