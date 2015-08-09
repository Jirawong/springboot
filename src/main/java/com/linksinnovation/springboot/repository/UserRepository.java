package com.linksinnovation.springboot.repository;

import com.linksinnovation.springboot.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public interface UserRepository extends JpaRepository<Users, String>{
    
}
