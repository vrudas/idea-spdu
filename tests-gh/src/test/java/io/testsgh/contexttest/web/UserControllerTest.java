package io.testsgh.contexttest.web;

import io.testsgh.contexttest.config.SimpleContextConfig;
import io.testsgh.contexttest.config.WebConfig;
import io.testsgh.contexttest.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {SimpleContextConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterMethod
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void testSave() throws Exception {
        mockMvc.perform(
            post("/users/save")
                .param("login", "batman")
                .param("password", "bruce_wayne")
        ).andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/users/flash"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() {
    }
}