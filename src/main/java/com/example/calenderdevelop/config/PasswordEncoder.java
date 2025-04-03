package com.example.calenderdevelop.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encode(String rawPassword){
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST,rawPassword.toCharArray());
    }

    public boolean matches(String rawPassword,String endcodedPassword){
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(),endcodedPassword);
        return result.verified;
    }
}
