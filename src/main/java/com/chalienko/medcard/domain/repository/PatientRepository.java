package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("SELECT p from Patient p WHERE p.doctor.id = ?1")
    List<Patient> getPatientByDoctorId(Long id);
}
