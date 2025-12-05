package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint para agregar un nuevo usuario
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user); // Guarda el usuario en la base de datos
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);  // Responde con el usuario creado
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
