package com.example.innovance.service;

import com.example.innovance.dto.UserCreateDTO;
import com.example.innovance.dto.UserUpdateDTO;
import com.example.innovance.dto.UserViewDTO;
import com.example.innovance.model.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {
    UserViewDTO getUserById(Integer id) throws ChangeSetPersister.NotFoundException;
    UserViewDTO createUser(UserCreateDTO userCreateDTO);
    List<UserViewDTO> getUsers();
    UserViewDTO updateUser(Integer id, UserUpdateDTO userUpdateDTO) throws ChangeSetPersister.NotFoundException;
    void deleteUser(Integer id) throws ChangeSetPersister.NotFoundException;
    UserViewDTO getAccount(Integer id);
    void deleteUserAccount(Integer id) throws ChangeSetPersister.NotFoundException;
}
