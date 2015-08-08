package com.linksinnovation.springboot.dto;

import com.linksinnovation.springboot.validate.StartWith;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Getter
@Setter
public class Comment {
    @StartWith(value = "a",message = "xxxxx")
    @NotBlank(message = "comment not blank")
    private String comment;
    @NotBlank
    @NotNull
    private String author;   
}
