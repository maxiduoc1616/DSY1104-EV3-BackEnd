package com.example.backend.controller;

import com.example.backend.dto.LoginRequest;
// 🚨 Importar la nueva clase de respuesta 🚨
import com.example.backend.dto.LoginResponse; 
import com.example.backend.security.JwtUtil;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // El import para ResponseEntity.ok()
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            
            List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority().replace("ROLE_", ""))
                .collect(Collectors.toList());

            String token = jwtUtil.generateToken(loginRequest.getEmail(), roles);
            
            User user = userRepository.findByEmail(loginRequest.getEmail()) 
                                      .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            
            return ResponseEntity.ok(new LoginResponse(token, user.getId(), user.getNombre(), roles)); 

        } catch (Exception e) {
            System.err.println("Error de autenticación: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: Credenciales inválidas");
        }
    }

}