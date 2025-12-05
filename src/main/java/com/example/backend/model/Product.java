// src/main/java/com/example/backend/model/Product.java
package com.example.backend.model;

import jakarta.persistence.*; // o javax.persistence.* según versión

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usa AUTO_INCREMENT en MySQL
    private Long id;
    @Column(nullable = false, length = 120)
    private String name;
    private String category;
    private Double price;

    // Constructor vacío obligatorio para JPA
    public Product() {
    }

    // Constructor opcional
    public Product(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}