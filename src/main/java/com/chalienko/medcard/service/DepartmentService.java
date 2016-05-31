package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Department;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 11.05.2016.
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getById(Long id){
        return repository.getOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void insert(Department department) {
        repository.save(department);
    }

}
