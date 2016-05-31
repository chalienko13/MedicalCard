package com.chalienko.medcard.domain.model;

import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title")
    private String title;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="department")
    private List<User> users;

    public Department() {
    }

    public Department(String title, List<User> users) {
        this.title = title;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
