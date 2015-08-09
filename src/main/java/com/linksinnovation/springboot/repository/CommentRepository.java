package com.linksinnovation.springboot.repository;

import com.linksinnovation.springboot.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
}
