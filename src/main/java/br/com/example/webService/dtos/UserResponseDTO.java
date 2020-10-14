package br.com.example.webService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
