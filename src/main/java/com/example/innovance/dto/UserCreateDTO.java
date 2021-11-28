package com.example.innovance.dto;

import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer balance;
    private Integer currency;

}
