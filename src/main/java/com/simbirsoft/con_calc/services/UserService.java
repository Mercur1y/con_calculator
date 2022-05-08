package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Role;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.RoleRepo;
import com.simbirsoft.con_calc.view.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    private boolean addOnce = true;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepo.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public boolean isAdminAdded () {
        User userFromDb = userRepo.findByUsername("admin");

        return userFromDb != null;
    }

    @Transactional
    public void initDB () {
        if(addOnce){
            Query query = em.createNativeQuery(
                    "insert into t_role(id, name)" + "values(?,?)");
            query.setParameter(1, 1L);
            query.setParameter(2, "ROLE_USER");
            query.executeUpdate();

            Query query1 = em.createNativeQuery(
                    "insert into t_role(id, name)" + "values(?,?)");
            query1.setParameter(1, 2L);
            query1.setParameter(2, "ROLE_ADMIN");
            query1.executeUpdate();

            Query query2 = em.createNativeQuery(
                    "insert into t_user (id, password, username)" + "values(?,?,?)");
            query2.setParameter(1, 1L);
            query2.setParameter(2, passwordEncoder.encode("admin"));
            query2.setParameter(3, "admin");
            query2.executeUpdate();

            Query query3 = em.createNativeQuery("insert into t_user_roles (user_id, roles_id)" + "values(?,?)");
            query3.setParameter(1, 1L);
            query3.setParameter(2, 2L);
            query3.executeUpdate();
            addOnce = false;
        }
    }
}
