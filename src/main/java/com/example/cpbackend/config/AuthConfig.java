package com.example.cpbackend.config;

import com.example.cpbackend.entity.LoginRequest;
import com.example.cpbackend.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    /*JWT step*/

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    /*Authentication STEP*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* change to userDetailsService */

        auth.userDetailsService(jwtUserDetailsService);
//        auth.inMemoryAuthentication()
//                .withUser("kien")
//                .password("admin")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .and()
//                .;
    }

    /*Authorization STEP*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user").hasAnyRole(LoginRequest.ADMIN, LoginRequest.STAFF)
                .antMatchers("/api/employee/**").hasRole(LoginRequest.ADMIN)
                .antMatchers("/api/trip/**").hasRole(LoginRequest.ADMIN)
                .antMatchers("/api/booking-office/**").hasRole(LoginRequest.ADMIN)
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }//Authorization


    /*Authentication STEP*/

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
