package com.linksinnovation.springboot.domain;

import com.linksinnovation.springboot.validate.StartWith;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public class Comment {
    @StartWith(value = "a",message = "xxxxx")
    @NotBlank(message = "comment not blank")
    private String comment;
    @NotBlank
    @NotNull
    private String author;   

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
