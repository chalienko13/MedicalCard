package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.Role;
import com.chalienko.medcard.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id){
        return roleRepository.getOne(id);
    }
}
