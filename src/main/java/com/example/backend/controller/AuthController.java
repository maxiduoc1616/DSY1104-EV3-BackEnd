// package com.example.backend.controller;

// import com.example.backend.security.JwtUtil;
// import org.springframework.web.bind.annotation.*;
// import java.util.Arrays;

// @RestController
// public class AuthController {

//     private final JwtUtil jwtUtil;

//     public AuthController(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody UserLogin userLogin) {
//         if ("user".equals(userLogin.getUsername()) && "password".equals(userLogin.getPassword())) {
//             String role = userLogin.getUsername().equals("admin") ? "ADMIN" : "USER";
//             return jwtUtil.generateToken(userLogin.getUsername(), Arrays.asList(role));
//         } else {
//             throw new RuntimeException("Invalid credentials");
//         }
//     }
// }
