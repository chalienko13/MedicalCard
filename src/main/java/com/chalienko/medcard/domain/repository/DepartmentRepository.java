package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Modifying
    @Query("delete from Department where id = ?1")
    void delete(Long id);
}
