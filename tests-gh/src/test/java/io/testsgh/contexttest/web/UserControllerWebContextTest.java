package io.testsgh.contexttest.web;

import io.testsgh.contexttest.config.SimpleContextConfig;
import io.testsgh.contexttest.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = {SimpleContextConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerWebContextTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testServletContextInitialized() {
        ServletContext servletContext = wac.getServletContext();
        assertNotNull(servletContext);
    }
    @Test
    public void testServletContextIsMockContext() {
        ServletContext servletContext = wac.getServletContext();
        assertTrue(servletContext instanceof MockServletContext);
    }

    @Test
    public void testServletContextHasBean() {
        ServletContext servletContext = wac.getServletContext();
        assertNotNull(wac.getBean("userController"));
    }

    @Test
    public void testRegistration() throws Exception {
        mockMvc.perform(
            post("/users/save")
                .param("login", "batman")
                .param("password", "bruce_wayne")
        ).andExpect(status().isOk());

        mockMvc.perform(get("/users/batman")).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.login").exists())
            .andExpect(jsonPath("$.password").exists());
    }
}
