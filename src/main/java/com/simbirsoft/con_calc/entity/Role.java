package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    @Column
    Long id;

    @Column
    String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
