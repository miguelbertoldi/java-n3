package br.edu.catolicasc.to_do.domain.dto;

public record TasksProgressDTO(
        long totalTasks,
        long finishedTasks,
        double finishedTasksPercent
) {
}
