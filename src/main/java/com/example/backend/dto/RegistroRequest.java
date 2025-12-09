package com.example.backend.dto;

public class RegistroRequest {
    
    private String email;
    private String password;
    private String nombre; 
    private String apellido; 
    private String phone;
    private String codigoPromocional;
    private boolean mayorDe50;
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCodigoPromocional() {
        return codigoPromocional;
    }

    public void setCodigoPromocional(String codigoPromocional) {
        this.codigoPromocional = codigoPromocional;
    }

    public boolean isMayorDe50() {
        return mayorDe50;
    }

    public void setMayorDe50(boolean mayorDe50) {
        this.mayorDe50 = mayorDe50;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}