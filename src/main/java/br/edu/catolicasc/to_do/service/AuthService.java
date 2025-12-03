package br.edu.catolicasc.to_do.service;

import br.edu.catolicasc.to_do.domain.dto.UserLoginDTO;
import br.edu.catolicasc.to_do.domain.dto.UserPostDTO;
import br.edu.catolicasc.to_do.domain.dto.UserResponseDTO;
import br.edu.catolicasc.to_do.domain.entity.User;
import br.edu.catolicasc.to_do.domain.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserResponseDTO register(UserPostDTO dto) {
        if (Objects.equals(dto.password(), dto.confirmPassword())) {
            UserResponseDTO response = userService.saveUser(dto);
        }
        throw new RuntimeException("Passwords don't match");
    }

    public UserResponseDTO login(UserLoginDTO dto) {
        User user = userService.findByUsername(dto.username());
        if (BCrypt.checkpw(dto.password(), user.getPassword())) {
            return userMapper.toDTO(dto);
        }

        throw new RuntimeException("Invalid password");
    }

}
