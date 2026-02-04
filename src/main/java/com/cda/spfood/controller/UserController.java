package com.cda.spfood.controller;

import com.cda.spfood.dtos.users.UserRequestDTO;
import com.cda.spfood.dtos.users.UserResponseDTO;
import com.cda.spfood.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.find(id));
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserRequestDTO user) {
        userService.save(user);
        return ResponseEntity.ok("{\"message\": \"Utilisateur à bien été modifié\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO user) {
        userService.update(id, user);
        return ResponseEntity.ok("{\"message\": \"Utilisateur à bien été modifié\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Utilisateur à bien été supprimé\"}");
    }
}
