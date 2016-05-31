package com.chalienko.medcard.domain.model;

import javax.persistence.*;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Entity
@Table(name = "analises")
public class Analises {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "analises_type")
    private String analisesType;

    public Analises() {
    }

    public Analises(String analisesType) {
        this.analisesType = analisesType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnalisesType() {
        return analisesType;
    }

    public void setAnalisesType(String analisesType) {
        this.analisesType = analisesType;
    }
}
