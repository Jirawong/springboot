package com.linksinnovation.springboot.repository;

import com.linksinnovation.springboot.dto.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    public List<Comment> findByCommentLike(String comment);
    public List<Comment> findByCommentAndAuthor(String comment,String author);
}
