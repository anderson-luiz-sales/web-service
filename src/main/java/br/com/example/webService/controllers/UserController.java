package br.com.example.webService.controllers;

import br.com.example.webService.dtos.UserRequestDTO;
import br.com.example.webService.dtos.UserResponseDTO;
import br.com.example.webService.facades.UserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/webservice/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @ApiOperation(value = "Post Users v1")
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userFacade.save(userRequestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Users v1")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        return new ResponseEntity<>(userFacade.getUsers(), HttpStatus.OK);
    }

    @ApiOperation(value =  "Get Users Password v1")
    @GetMapping("/password")
    public ResponseEntity<List<UserResponseDTO>> listUsersPassword() {
        return new ResponseEntity<>(userFacade.findAllUser(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get By Id User v1")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userFacade.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User v1")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
