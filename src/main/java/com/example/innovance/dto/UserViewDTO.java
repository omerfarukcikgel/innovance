package com.example.innovance.dto;

import com.example.innovance.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer balance;
    private Integer currency;

    private UserViewDTO(Integer id, String name, String surname, String email, Integer balance, Integer currency){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.balance= balance;
        this.currency=currency;
    }



    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getId(),user.getName(), user.getSurname(), user.getEmail(), user.getBalance(),user.getCurrency());
    }

}
