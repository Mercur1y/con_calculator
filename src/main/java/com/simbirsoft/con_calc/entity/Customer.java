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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Customer() {
    }

    public Customer(
            String firstName,
            String secondName,
            String lastName,
            String email,
            Long phone,
            String adress
    ) {
        this.first_name = firstName;
        this.second_name = secondName;
        this.last_name = lastName;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
