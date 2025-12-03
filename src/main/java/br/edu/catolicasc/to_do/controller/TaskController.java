package br.edu.catolicasc.to_do.controller;

import br.edu.catolicasc.to_do.domain.dto.TaskPostDTO;
import br.edu.catolicasc.to_do.domain.dto.TaskResponseDTO;
import br.edu.catolicasc.to_do.domain.dto.TasksProgressDTO;
import br.edu.catolicasc.to_do.domain.entity.Task;
import br.edu.catolicasc.to_do.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(TaskPostDTO dto) {
        TaskResponseDTO responseDTO =
                taskService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping("/progress")
    public ResponseEntity<TasksProgressDTO> calculateTasksProgress() {
        TasksProgressDTO dto =
                taskService.calculateTasksProgress();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }
    @GetMapping
    public ResponseEntity<List<Task>> findAll() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findAll());
    }


    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<?> complete(@PathVariable Long taskId) {
        taskService.complete(taskId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PatchMapping("/{taskId}/pending")
    public ResponseEntity<?> pending(@PathVariable Long taskId) {
        taskService.pending(taskId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> delete(@PathVariable Long taskId) {
        taskService.delete(taskId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


}
