package io.testsgh.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

@SpringBootTest
public class BootApplicationTest extends AbstractTestNGSpringContextTests {

    @MockBean
    @Autowired
    private UserRepository userRepository;

    @BeforeMethod
    public void setUp() {
        User user = createUser();

        when(userRepository.findById(eq("flash"))).thenReturn(Optional.of(user));
    }

    private User createUser() {
        User user = new User();

        user.setLogin("flash");
        user.setPassword("barry_allen");

        return user;
    }

    @Test
    public void user_exists() {
        assertTrue(userRepository.findById("flash").isPresent());
    }

}