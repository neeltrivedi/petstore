//package com.example.nt.security;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//
//@Configuration
//@EnableWebSecurity
//public class PetSecurityConfigurer extends WebSecurityConfigurerAdapter {
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
// 
//        http
//         
//        // no session management required
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//         
//        // the following URLs should be permitted without any authentication
//        // this includes our static resources
//        // **Note** : We don't yet have a login page and will be using default browser auth,
//        // so we want the default Add book page ("/") to come up without authentication
//        .authorizeRequests()
//        .antMatchers("/css/**", "/app/**", "/pages/**", "/").permitAll()
//         
//        // all other requests must be authenticated
//        .anyRequest().fullyAuthenticated()
//        .and()
//         
//        // use basic HTTP authentication - so the browser will display a prompt automatically
//        .httpBasic()
//        .and()
//         
//        // disable Cross Site Request Forgery token
//        // we do not rely on cookie based auth and are completely stateless so we are safe
//        .csrf().disable();
//    }
//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // here we define two hard coded users (one admin and one user)
//        auth
//        .inMemoryAuthentication()
//        .withUser("user")
//        .password("pass")
//        .roles("USER")
//        .and()
//        .withUser("admin")
//        .password("pass")
//        .roles("ADMIN");
//    }
//}