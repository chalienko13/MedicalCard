package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Patient;
import com.chalienko.medcard.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Long id) {
        return patientRepository.getOne(id);
    }
    public List<Patient> getPatientsByDoctorId(Long id){
        return patientRepository.getPatientByDoctorId(id);
    }

    public void insertPatient(Patient patient){
        patientRepository.save(patient);}

}
