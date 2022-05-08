package com.simbirsoft.con_calc.entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_user")
public class User extends AbstractHuman implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id", initialValue = 2)
    private Long id;

    @Size(min=2, message = "Не меньше 5 знаков")
    @NotBlank(message = "Поле логина не может быть пустым")
    private String username;

    @NotBlank(message = "Поле пароля не может быть пустым")
    @Size(min=2, message = "Не меньше 5 знаков")
    private String password;

    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getLast_name() {
        return super.getLast_name();
    }

    @Override
    public void setLast_name(String last_name) {
        super.setLast_name(last_name);
    }

    @Override
    public String getFirst_name() {
        return super.getFirst_name();
    }

    @Override
    public void setFirst_name(String first_name) {
        super.setFirst_name(first_name);
    }

    @Override
    public String getSecond_name() {
        return super.getSecond_name();
    }

    @Override
    public void setSecond_name(String second_name) {
        super.setSecond_name(second_name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public int getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(int phone) {
        super.setPhone(phone);
    }
}
