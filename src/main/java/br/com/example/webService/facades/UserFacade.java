package br.com.example.webService.facades;

import br.com.example.webService.dtos.UserRequestDTO;
import br.com.example.webService.dtos.UserResponseDTO;

import java.util.List;

public interface UserFacade {

    UserResponseDTO save(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getUsers();
    UserResponseDTO findById(Long id);
    void deleteById(Long id);
    List<UserResponseDTO> findAllUser();
}
