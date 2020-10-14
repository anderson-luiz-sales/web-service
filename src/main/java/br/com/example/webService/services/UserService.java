package br.com.example.webService.services;

import br.com.example.webService.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> getUsers();
    User findById(Long id);
    void deleteById(Long id);
    List<User> findAllUser();
}
