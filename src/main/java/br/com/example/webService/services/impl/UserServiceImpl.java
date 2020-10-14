package br.com.example.webService.services.impl;

import br.com.example.webService.entities.User;
import br.com.example.webService.exptions.NotFoundException;
import br.com.example.webService.repositories.UserRepository;
import br.com.example.webService.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        log.info("[UserServiceImpl.save] - course: {}", user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        log.info("[UserServiceImpl.findAll]");
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        log.info("[CourseServiceImpl.findById] - id: {}");

        if (userRepository.findById(id) == null) {
            throw new NotFoundException("Not found for id" + id);
        }
        return userRepository.findByid(id);
    }

    @Override
    public void deleteById(Long id) {
        log.info("UserServiceImpl.deleteById - id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAlluserPassword();
    }
}
