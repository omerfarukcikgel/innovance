package com.example.innovance.api;

import com.example.innovance.dto.UserCreateDTO;
import com.example.innovance.dto.UserUpdateDTO;
import com.example.innovance.dto.UserViewDTO;
import com.example.innovance.service.UserService;
import com.example.innovance.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;
    @GetMapping("user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse(("user created.")));
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> user = userService.getUsers();
        return ResponseEntity.ok(user);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserUpdateDTO userUpdateDTO) throws ChangeSetPersister.NotFoundException {
        final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("user deleted."));
    }
    @GetMapping("user/account/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok("Balance: "+user.getBalance()+"\nCurrency: "+user.getCurrency());
    }

}
