package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Medicament;
import com.chalienko.medcard.domain.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Service
public class MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;
    public List<Medicament> getAll(){
       return medicamentRepository.findAll();
    }
    public void addMedicament(Medicament medicament){
        medicamentRepository.save(medicament);
    }
    public Medicament getByTitle(String title){
        return medicamentRepository.getByTitle(title);
    }

    public void delete(Long id){ medicamentRepository.delete(id);}

}
