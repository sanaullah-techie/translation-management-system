package com.digitaltolk.translation.service.impl;

import com.digitaltolk.translation.entity.User;
import com.digitaltolk.translation.repository.UserRepository;
import com.digitaltolk.translation.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public String login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtUtil.generateToken(username);
    }

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(com.digitaltolk.translation.util.Role.USER)
                .build();
        userRepository.save(user);
        return jwtUtil.generateToken(username);
    }

}
