package br.edu.catolicasc.to_do.domain.mapper;

import br.edu.catolicasc.to_do.domain.dto.UserLoginDTO;
import br.edu.catolicasc.to_do.domain.dto.UserPostDTO;
import br.edu.catolicasc.to_do.domain.dto.UserResponseDTO;
import br.edu.catolicasc.to_do.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserPostDTO dto);
    UserResponseDTO toDTO(UserLoginDTO user);
    UserResponseDTO toDTO(User user);
}
