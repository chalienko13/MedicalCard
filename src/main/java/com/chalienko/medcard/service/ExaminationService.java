package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Examination;
import com.chalienko.medcard.domain.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Service
public class ExaminationService {
    @Autowired
    private ExaminationRepository examinationRepository;
    public void save(Examination examination){
        examinationRepository.save(examination);
    }
}
