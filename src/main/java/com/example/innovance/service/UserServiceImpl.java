package com.example.innovance.service;

import com.example.innovance.dto.UserCreateDTO;
import com.example.innovance.dto.UserUpdateDTO;
import com.example.innovance.dto.UserViewDTO;
import com.example.innovance.model.User;
import com.example.innovance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserViewDTO getUserById(Integer id) throws ChangeSetPersister.NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getId(),userCreateDTO.getName(),userCreateDTO.getSurname(),userCreateDTO.getEmail(), userCreateDTO.getBalance(), userCreateDTO.getCurrency()));
        return UserViewDTO.of(user);
    }

    @Override
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDTO updateUser(Integer id, UserUpdateDTO userUpdateDTO) throws ChangeSetPersister.NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        user.setName(userUpdateDTO.getName());
        user.setSurname(userUpdateDTO.getSurname());

        final User uptadedUser = userRepository.save(user);
        return UserViewDTO.of(uptadedUser);
    }

    @Override
    public void deleteUser(Integer id) throws ChangeSetPersister.NotFoundException {
        final User user = userRepository.findById(id).orElseThrow(()->new ChangeSetPersister.NotFoundException());
        userRepository.deleteById(user.getId());
    }

    @Override
    public UserViewDTO getAccount(Integer id) {
        return (UserViewDTO) userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }


}
