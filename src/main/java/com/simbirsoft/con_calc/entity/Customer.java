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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Frame> frames;

    public Customer() {
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

    public Set<Frame> getFrames() {
        return frames;
    }

    public void setFrames(Set<Frame> frames) {
        this.frames = frames;
    }
}
