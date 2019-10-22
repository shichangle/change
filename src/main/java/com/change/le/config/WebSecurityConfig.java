//package com.change.le.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//
//import java.security.AuthProvider;
//
///**
// * author shichangle
// * date 2019/10/22 0022 20:01
// */
//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    /**
//     * Http权限控制
//     */
//
//    /**
//     * 自动以认证策略
//     */
//    @Autowired
//    public void configGlobal(AuthenticationManagerBuilder auth) {
//
//    }
//
//    @Bean
//    public AuthProvider authProvider() {
//        return new AuthProvider();
//    }
//
//    @Bean
//    public LoginUrlAuthenticationEntryPoint urlEntryPoint(){
//        return new LoginUrlAuthenticationEntryPoint("/user/login");
//    }
//
//    @Bean
//    public LoginAuthFailHander authFailHandler() {
//        return new LoginAuthFailHander(urlEntryPoint());
//    }
//
//
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        AuthenticationManager authenticationManager = null;
//        try {
//            authenticationManager =  super.authenticationManager();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return authenticationManager;
//    }
//
//    @Bean
//    public AuthFilter authFilter() {
//        AuthFilter authFilter = new AuthFilter();
//        authFilter.setAuthenticationManager(authenticationManager());
//        authFilter.setAuthenticationFailureHandler(authFailHandler());
//        return authFilter;
//    }
//
//}
