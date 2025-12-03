package br.edu.catolicasc.to_do.service;

import br.edu.catolicasc.to_do.domain.dto.TasksProgressDTO;
import br.edu.catolicasc.to_do.domain.entity.Task;
import br.edu.catolicasc.to_do.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public TasksProgressDTO calculateTasksProgress() {
        long totalTasks = taskRepository.count();

    }

}
