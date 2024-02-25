package com.example.aigame.service;

import com.example.aigame.model.CustomUserDetails;
import com.example.aigame.model.User;
import com.example.aigame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.aigame.security.JwtTokenUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            CustomUserDetails userDetails = new CustomUserDetails(user);
            return jwtTokenUtil.generateToken(userDetails);
        } else {
            return null;
        }
    }
}
