package com.chalienko.medcard.config;

import com.chalienko.medcard.domain.model.Role;
import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 10.05.2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            Role role = user.getRole();
            List<String> userRoles = new ArrayList<>();
            userRoles.add(role.getRole());
            return new CustomUserDetails(user,userRoles);
        }
    }
}

