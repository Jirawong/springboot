package com.linksinnovation.springboot.controller;

import com.linksinnovation.springboot.dto.Comment;
import com.linksinnovation.springboot.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private CommentRepository commentRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> home(){    
        return commentRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@Validated @RequestBody Comment comment ){
        return commentRepository.save(comment);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public List<Comment> delete(@PathVariable("id") Integer id){
        commentRepository.delete(id);
        return commentRepository.findAll();
    }
    
}
