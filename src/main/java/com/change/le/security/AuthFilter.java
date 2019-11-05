package com.change.le.security;

import com.change.le.POJO.entity.UserDO;
import com.change.le.service.UserService;
import org.elasticsearch.common.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * author shichangle
 * date 2019/10/22 0022 20:17
 */
public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserService userService;

//    @Autowired
//    private SmsService smsService;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String name = obtainUsername(request);
        if(!Strings.isNullOrEmpty(name)){
         request.setAttribute("username",name);
         return super.attemptAuthentication(request,response);
        }

//        String telephone = request.getParameter("telephone");
//        if (Strings.isNullOrEmpty(telephone) || !LoginUserUtil.checkTelephone(telephone)) {
//            throw new BadCredentialsException("Wrong telephone number");
//        }

        UserDO user = userService.findUserByName(name);
//        if(user==null){
//
//        }
        return new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
    }




}
