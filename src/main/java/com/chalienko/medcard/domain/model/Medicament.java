package com.chalienko.medcard.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Entity
@Table(name = "medicament")
public class Medicament implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "comments")
    private String comments;

    public Medicament() {
    }

    public Medicament(String title, String comments) {
        this.title = title;
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
