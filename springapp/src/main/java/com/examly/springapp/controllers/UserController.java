package com.examly.springapp.controllers;

import com.examly.springapp.dto.RoleDTO;
import com.examly.springapp.dto.UserDTO;
import com.examly.springapp.entities.User;
import com.examly.springapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ POST - Register User
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> userRequest) {
        String email = userRequest.get("email");
        String password = userRequest.get("password");
        String roleName = userRequest.get("role");

        if (email == null || password == null || roleName == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Missing required fields"));
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        user = userService.saveUser(user, Set.of(roleName)); // ✅ Save user with role

        return ResponseEntity.ok(convertToUserDTO(user)); // ✅ Return formatted response
    }

    // ✅ GET - Fetch User by Email
    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.findUserByEmail(email);

        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User not found"));
        }

        return ResponseEntity.ok(convertToUserDTO(userOptional.get())); // ✅ Return formatted response
    }

    // ✅ PUT - Update User Role
    @PutMapping("/updateRole")
    public ResponseEntity<?> updateUserRole(@RequestParam String email, @RequestParam String roleName) {
        User updatedUser = userService.updateUserRole(email, roleName);
        return ResponseEntity.ok(convertToUserDTO(updatedUser)); // ✅ Return formatted response
    }

    // ✅ DELETE - Delete User
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok(Collections.singletonMap("message", "User deleted successfully"));
    }

    // ✅ GET - Fetch All Users (Only for ADMIN)
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream().map(this::convertToUserDTO).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs); // ✅ Return list of users formatted correctly
    }

    // ✅ Utility Method: Convert User to UserDTO
    private UserDTO convertToUserDTO(User user) {
        Set<RoleDTO> roles = user.getRoles().stream()
                .map(role -> new RoleDTO(role.getId(), role.getRoleName()))
                .collect(Collectors.toSet());

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(), // Encrypted password returned
                user.getPreferredCurrency(),
                user.getContactInfo(),
                user.getProfilePicture(),
                roles
        );
    }
}