package br.edu.catolicasc.to_do.service;

import br.edu.catolicasc.to_do.domain.dto.UserPostDTO;
import br.edu.catolicasc.to_do.domain.dto.UserResponseDTO;
import br.edu.catolicasc.to_do.domain.entity.User;
import br.edu.catolicasc.to_do.domain.mapper.UserMapper;
import br.edu.catolicasc.to_do.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO saveUser(UserPostDTO dto) {
        String hashedPassword = BCrypt.hashpw(dto.password(), BCrypt.gensalt());

        User user = new User(
                dto.name(),
                dto.username(),
                hashedPassword
        );

        return userMapper.toDTO(userRepository.save(user));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(RuntimeException::new);
    }

}
