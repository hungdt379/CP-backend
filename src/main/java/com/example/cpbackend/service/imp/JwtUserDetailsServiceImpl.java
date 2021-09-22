package com.example.cpbackend.service.imp;

import com.example.cpbackend.entity.Employee;
import com.example.cpbackend.entity.LoginRequest;
import com.example.cpbackend.repository.IEmployeeRepository;
import com.example.cpbackend.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = iEmployeeRepository.findEmployeeByAccount(s);
        if (employee != null){
            return new User(employee.getAccount(), employee.getPassword(), Arrays.asList(new SimpleGrantedAuthority(LoginRequest.ROLE_ADMIN)));
        }
        throw new UsernameNotFoundException("User "+ s+ " not found");
    }
}
