package com.linksinnovation.springboot.controller;

import com.linksinnovation.springboot.domain.Comment;
import com.linksinnovation.springboot.repository.CommentRepository;
import com.linksinnovation.springboot.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> listAll() {
        return commentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment getOne(@PathVariable("id") Integer id) {
        return commentRepository.findOne(id);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@Validated @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Comment update(@Validated @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Comment> delete(@PathVariable("id") Integer id) {
        Comment findOne = commentRepository.findOne(id);
        commentRepository.delete(findOne);
        return commentRepository.findAll();
    }
    
    @RequestMapping(value = "/author/{author}",method = RequestMethod.GET)
    public List<Comment> findAuthor(@PathVariable("author") String author){
        return commentRepository.findByAuthor(author);
    }
    
    @RequestMapping(value = "/author/search/{author}",method = RequestMethod.GET)
    public List<Comment> searchAuthor(@PathVariable("author") String author){
        return commentRepository.findByAuthorLike("%"+author+"%");
    }
    
    @RequestMapping(value = "/comment/search/{comment}",method = RequestMethod.GET)
    public List<Comment> searchComment(@PathVariable("comment") String comment){
        return commentRepository.searchComment(comment);
    }

}
