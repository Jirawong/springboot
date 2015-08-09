package com.linksinnovation.springboot.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linksinnovation.springboot.Application;
import com.linksinnovation.springboot.dto.Comment;
import com.linksinnovation.springboot.repository.CommentRepository;
import java.util.Collections;
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
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
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
     * Test of home method, of class HomeRestController.
     */
    @org.junit.Test
    public void testHome() throws Exception {
       
        
        CommentRepository mock = Mockito.mock(CommentRepository.class);
        Mockito.when(mock.findAll()).thenReturn(Collections.EMPTY_LIST);
        
        ReflectionTestUtils.setField(homeRestController, "commentRepository", mock);
        
        String contentAsString = mockMvc
                .perform(MockMvcRequestBuilders.get("/api"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        
        System.out.println(contentAsString);
        
        ObjectMapper om = new ObjectMapper();
        List<Comment> readValue = om.
                readValue(contentAsString, new TypeReference<List<Comment>>(){});
        
        //System.out.println("test "+readValue.get(0).getAuthor());
        
        //assertTrue(true);
    }

    
}
