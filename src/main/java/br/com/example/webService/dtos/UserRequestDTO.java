package br.com.example.webService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String password;
}
