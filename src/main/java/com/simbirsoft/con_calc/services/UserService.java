package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.*;
import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.customer.CustomerListDto;
import com.simbirsoft.con_calc.dto.user.UserCreationDto;
import com.simbirsoft.con_calc.dto.user.UserEditDto;
import com.simbirsoft.con_calc.dto.user.UserListDto;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.mapper.CustomerMapper;
import com.simbirsoft.con_calc.mapper.UserMapper;
import com.simbirsoft.con_calc.view.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    private User findUserById(Long userId) {
        Optional<User> userFromDb = userRepo.findById(userId);
        return userFromDb.orElse(new User());
    }

    public UserEditDto getForEdit(Long id) {
        return userMapper.toEditDto(findUserById(id));
    }

    public Set<CustomerListDto> getDtoCustomersByUserId(Long id) {
        User user = findUserById(id);
        return user.getCustomers().stream().map(customerMapper::toListDto).collect(Collectors.toSet());
    }

    public Set<UserListDto> getAll() {
        return userRepo.findAll().stream().map(userMapper::toListDto).collect(Collectors.toSet());
    }

    public boolean add(UserCreationDto user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new RoleDto(2L, "USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus("В штате");
        userRepo.save(userMapper.toCreationEntity(user));
        return true;
    }

    public void updateUser(UserEditDto user, Long id) {
        User userFromDB = userRepo.getById(id);
        userFromDB.setUsername(user.getUsername());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setSecondName(user.getSecondName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setPhone(user.getPhone());
        userFromDB.setStatus(user.getStatus());
        userRepo.save(userFromDB);
    }

    public void deleteUser(Long userId) {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
        }
    }

    public boolean isAdminAdded () {
        User userFromDb = userRepo.findByUsername("admin");
        return userFromDb != null;
    }
}
