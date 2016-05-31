package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}

