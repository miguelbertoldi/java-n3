package br.edu.catolicasc.to_do.domain.dto;

import java.util.UUID;

public record UserResponseDTO(

        UUID uid,
        String name,
        String username

) { }
