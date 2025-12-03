package br.edu.catolicasc.to_do.service;

import br.edu.catolicasc.to_do.domain.dto.TaskPostDTO;
import br.edu.catolicasc.to_do.domain.dto.TaskResponseDTO;
import br.edu.catolicasc.to_do.domain.dto.TasksProgressDTO;
import br.edu.catolicasc.to_do.domain.entity.Task;
import br.edu.catolicasc.to_do.domain.enumerator.Status;
import br.edu.catolicasc.to_do.domain.mapper.TaskMapper;
import br.edu.catolicasc.to_do.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public TaskResponseDTO create(TaskPostDTO dto) {
        Task task = taskMapper.toEntity(dto);
        taskRepository.save(task);
        return taskMapper.toDTO(task);
    }

    public void complete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        task.setStatus(Status.DONE);
        taskRepository.save(task);
    }

    public void pending(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        task.setStatus(Status.TODO);
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public TasksProgressDTO calculateTasksProgress() {
        long totalTasks = taskRepository.count();
        long finishedTasks = taskRepository.countByStatus(Status.DONE);
        double finishedTasksPercent = taskRepository.countByStatus(Status.DONE);

        return new TasksProgressDTO(
                totalTasks,
                finishedTasks,
                finishedTasksPercent
        );
    }

}
