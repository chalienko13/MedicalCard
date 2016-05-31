package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Analises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Repository
public interface AnalisesRepository extends JpaRepository<Analises,Long> {

}
