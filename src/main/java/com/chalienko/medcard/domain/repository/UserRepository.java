package com.chalienko.medcard.domain.repository;

import com.chalienko.medcard.domain.model.User;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserName(String userName);

    @Query(value = "SELECT u FROM User u Where u.role.id = 4")
    List<User> getAllDoctors();

    @Query(value = "SELECT u FROM User u Where u.role.id = 3")
    List<User> getAllRegisters();
    @Modifying
    @Query("delete from User where id = ?1")
    void delete(Long id);
}