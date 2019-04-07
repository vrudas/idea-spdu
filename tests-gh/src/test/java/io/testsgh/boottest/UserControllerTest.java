package io.testsgh.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
//@SpringBootTest
//@AutoConfigureMockMvc
public class UserControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

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

}
