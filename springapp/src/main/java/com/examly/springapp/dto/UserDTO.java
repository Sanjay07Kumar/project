package com.examly.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id; // ✅ Include ID in response

    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String password; // ✅ Encrypted in response

    private String preferredCurrency;
    private String contactInfo;
    private String profilePicture;

    private Set<RoleDTO> roles; // ✅ List of roles
}
