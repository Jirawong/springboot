package com.linksinnovation.springboot.controller;

import com.linksinnovation.springboot.domain.Comment;
import com.linksinnovation.springboot.repository.CommentRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {

        List<Comment> comments = commentRepository.findAll();

        model.addAttribute("comments", comments);
        model.addAttribute("formComment", new Comment());

        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("formComment") @Valid Comment formComment, BindingResult result, Model model) {

        if (!result.hasErrors()) {
            commentRepository.save(formComment);
        }

        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("formComment", new Comment());
        return "index";
    }

}
