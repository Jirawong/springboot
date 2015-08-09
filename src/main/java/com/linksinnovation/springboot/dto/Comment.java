package com.linksinnovation.springboot.dto;

import com.linksinnovation.springboot.validate.StartWith;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "comment not blank")
    private String comment;
    @NotBlank
    private String author; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
}
