package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // Asegúrate de que el nombre de la tabla sea correcto
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // IMPORTANTE: Asegúrate de que el email es UNICO a nivel de DB
    @Column(nullable = false, unique = true) 
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String nombre;
    private String apellido; 
    private String phone;   
    private String codigoPromocional;
    private boolean mayorDe50;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private Role role; 

    public User() {}
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCodigoPromocional() { return codigoPromocional; }
    public void setCodigoPromocional(String codigoPromocional) { this.codigoPromocional = codigoPromocional; }
    public boolean isMayorDe50() { return mayorDe50; }
    public void setMayorDe50(boolean mayorDe50) { this.mayorDe50 = mayorDe50; }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}