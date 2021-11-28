package com.example.innovance.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer balance;
    private Integer currency;
}
