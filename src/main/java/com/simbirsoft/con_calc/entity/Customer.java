package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_customer")
public class Customer extends AbstractHuman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private Set<User> users;

    public Customer() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
