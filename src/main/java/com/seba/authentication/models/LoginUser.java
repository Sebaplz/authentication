package com.seba.authentication.models;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUser {

    private Long id;
    @NotBlank(message = "Por favor, no olvides ingresar un correo electronico")
    @Email(message = "El correo ingresado no es valido!")
    private String email;
    @NotBlank(message = "Por favor, ingresa un password")
    @Size(min = 8, max = 64, message = "El password debe contener entre 8 y 20 caracteres")
    private String password;

    public LoginUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
