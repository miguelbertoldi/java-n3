package br.edu.catolicasc.to_do.exception;

public record ApiError(
        int status,
        String message
) { }
