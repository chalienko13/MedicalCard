package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Repository
public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    Medicament getByTitle(String title);
}
