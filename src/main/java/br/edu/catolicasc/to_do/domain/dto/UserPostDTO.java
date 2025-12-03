package br.edu.catolicasc.to_do.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPostDTO(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "E-mail is required")
        @Email
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must have at least 8 characters")
        String password,

        @NotBlank(message = "Password confirmation is required")
        @Size(min = 8, message = "Password must have at least 8 characters")
        String confirmPassword

) { }
