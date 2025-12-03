package br.edu.catolicasc.to_do.domain.mapper;

import br.edu.catolicasc.to_do.domain.dto.*;
import br.edu.catolicasc.to_do.domain.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskPostDTO dto);
    TaskResponseDTO toDTO(Task task);
}