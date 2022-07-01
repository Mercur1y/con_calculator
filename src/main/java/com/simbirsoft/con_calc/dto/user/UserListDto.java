package com.simbirsoft.con_calc.dto.user;

import com.simbirsoft.con_calc.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {

    private Long id;
    private String username;
    private Set<Role> roles;
}
