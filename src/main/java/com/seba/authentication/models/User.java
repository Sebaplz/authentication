package com.seba.authentication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Debe ingresar un UserName!")
    @Size(min = 3, max = 30, message = "Nombre de usuario debe contener entre 3 y 30 caracteres")
    private String userName;
    @Column(unique=true)
    @NotBlank(message = "Por favor, no olvides ingresar un correo electronico")
    @Email(message = "El correo ingresado no es valido!")
    private String email;
    @NotBlank(message = "Por favor, ingresa un password")
    @Size(min = 8, max = 64, message = "El password debe contener entre 8 y 20 caracteres")
    private String password;
    @Transient
    @NotBlank(message = "Por favor, ingresa un password")
    @Size(min = 8, max = 64, message = "El password debe contener entre 8 y 20 caracteres")
    private String passwordConfirmation;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // otros getters y setters removidos para resumir.
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}