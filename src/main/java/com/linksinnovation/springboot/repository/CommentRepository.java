/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linksinnovation.springboot.repository;

import com.linksinnovation.springboot.domain.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    public List<Comment> findByAuthor(String author);
    public List<Comment> findByAuthorLike(String author);
    @Query("SELECT c FROM Comment c WHERE c.comment LIKE %?1%")
    public List<Comment> searchComment(String comment);
}
