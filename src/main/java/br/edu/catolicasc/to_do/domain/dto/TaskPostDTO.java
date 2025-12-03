package br.edu.catolicasc.to_do.domain.dto;

import br.edu.catolicasc.to_do.domain.enumerator.Status;
import jakarta.validation.constraints.NotBlank;

public record TaskPostDTO(
        @NotBlank(message = "Title is required")
        String title,

        String description,
        Status status
) {
}
