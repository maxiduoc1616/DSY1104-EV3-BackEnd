package com.example.backend.service;

import com.example.backend.dto.RegistroRequest;
import com.example.backend.model.Role;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegistroRequest request) {
        
        Role userRole = Role.USER;
        if (request.getRole() != null && request.getRole().equalsIgnoreCase("ADMIN")) {
            userRole = Role.ADMIN;
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setPhone(request.getPhone());
        user.setCodigoPromocional(request.getCodigoPromocional());
        user.setMayorDe50(request.isMayorDe50());
        
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(userRole);

        return userRepository.save(user);
    }
}