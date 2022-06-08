package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.CustomerDto;
import com.simbirsoft.con_calc.dto.RoleDto;
import com.simbirsoft.con_calc.dto.UserCreationDto;
import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.User;
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

    public UserDto get(Long id) {
        return userMapper.toDto(findUserById(id));
    }

    public Set<UserDto> getAll() {
        return userRepo.findAll().stream().map(userMapper::toDto).collect(Collectors.toSet());
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

    public void updateUser(UserDto user, Long id) {
        User userFromDB = userRepo.getById(id);
        userFromDB.setUsername(user.getUsername());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setFirst_name(user.getFirst_name());
        userFromDB.setSecond_name(user.getSecond_name());
        userFromDB.setLast_name(user.getLast_name());
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
