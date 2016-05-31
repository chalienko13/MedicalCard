package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Analises;
import com.chalienko.medcard.domain.repository.AnalisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Service
public class AnalisesService {
    @Autowired
    private AnalisesRepository analisesRepository;

    public Analises getById(Long id){
        return analisesRepository.getOne(id);
    }

    public List<Analises> getAll(){
        return analisesRepository.findAll();
    }

    public void insert(Analises analises) {
        analisesRepository.save(analises);
    }

    public void delete(Long id){
        analisesRepository.delete(id);
    }
}
