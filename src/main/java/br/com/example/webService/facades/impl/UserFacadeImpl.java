package br.com.example.webService.facades.impl;

import br.com.example.webService.dtos.UserRequestDTO;
import br.com.example.webService.dtos.UserResponseDTO;
import br.com.example.webService.entities.User;
import br.com.example.webService.facades.UserFacade;
import br.com.example.webService.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        return convertToDTO(userService.save(convertToEntity(userRequestDTO)));
    }

    @Override
    public List<UserResponseDTO> getUsers() {
        List<UserResponseDTO> userList = new ArrayList<>();

        for (User user : userService.getUsers()) {
            userList.add(convertToDTO(user));
        }

        return userList;
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return convertToDTO(userService.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Override
    public List<UserResponseDTO> findAllUser() {
        List<UserResponseDTO> userList = new ArrayList<>();

        for (User user : userService.findAllUser()) {
            userList.add(convertToDTO(user));
        }

        return userList;
    }

    private User convertToEntity(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, User.class);
    }

    private UserResponseDTO convertToDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
