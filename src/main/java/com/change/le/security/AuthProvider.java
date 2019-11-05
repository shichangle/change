package com.change.le.security;

import com.change.le.POJO.entity.UserDO;
import com.change.le.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.*;

/**
 * author shichangle
 * date 2019/11/4 0004 16:15
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    //private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String inputPassword = (String)authentication.getCredentials();
        UserDO user = userService.findUserByName(username);
        if(user==null){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        if(inputPassword.equals(user.getPassword())){
            return new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
