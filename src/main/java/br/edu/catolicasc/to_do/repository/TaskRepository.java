package br.edu.catolicasc.to_do.repository;

import br.edu.catolicasc.to_do.domain.entity.Task;
import br.edu.catolicasc.to_do.domain.enumerator.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository
        extends JpaRepository<Task, Long> {

    long countByStatus(Status status);

}
