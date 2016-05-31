package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Chalienko on 26.04.2016.
 */
@Repository
public interface ExaminationRepository extends JpaRepository<Examination,Long> {
}
