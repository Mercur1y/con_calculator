package com.simbirsoft.con_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {

    @Null
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String last_name;
    @NotBlank
    private String first_name;
    @NotBlank
    private String second_name;
    @NotBlank
    private String phone;
    private String status;
    private Set<RoleDto> roles;
}
