package br.edu.catolicasc.to_do.domain.dto;

import br.edu.catolicasc.to_do.domain.enumerator.Status;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        String tile,
        String description,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
