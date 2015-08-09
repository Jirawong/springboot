/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linksinnovation.springboot.controller;

import com.linksinnovation.springboot.Application;
import com.linksinnovation.springboot.domain.Comment;
import com.linksinnovation.springboot.service.CommentService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class HomeRestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private HomeRestController homeRestController;
    private MockMvc mockMvc;

    public HomeRestControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of listAll method, of class HomeRestController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testListAll() throws Exception {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("comment", "author"));

        CommentService mock = Mockito.mock(CommentService.class);
        Mockito.when(mock.findAll()).thenReturn(comments);

        ReflectionTestUtils.setField(homeRestController, "commentService", mock);

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/api")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
        assertEquals(contentAsString, "[]");
    }

}
