package com.linksinnovation.springboot.controller;

import com.linksinnovation.springboot.dto.Comment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class HomeRestController {
    
    @RequestMapping(method = RequestMethod.GET)
    public Comment home(){
        Comment comment = new Comment();
        comment.setComment("this is comment");
        comment.setAuthor("this is author");
        return comment;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@Validated @RequestBody Comment comment ){
        

        
        return comment;
    }
    
}
