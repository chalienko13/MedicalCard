package com.chalienko.medcard.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Entity
@Table(name = "examination")
public class Examination implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient")
    private Patient patient;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "diagnose")
    private String diagnose;
    @ManyToMany
    @JoinTable(
            name = "examination_medicament",
            joinColumns = @JoinColumn(name = "id_examination", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "id_medicament", referencedColumnName = "ID"))
    private List<Medicament> medicaments;

    public Examination() {
    }


    public Examination(User user, Patient patient, Timestamp date, String diagnose, List<Medicament> medicaments) {
        this.user = user;
        this.patient = patient;
        this.date = date;
        this.diagnose = diagnose;
        this.medicaments = medicaments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
