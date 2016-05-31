package com.chalienko.medcard.domain.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Entity
@Table(name = "role")
@Transactional
public class Role implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "role")
    private String role;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="role")
    private List<User> users;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
