package com.linksinnovation.springboot.service;

import com.linksinnovation.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOne(username);
    }
    
}
