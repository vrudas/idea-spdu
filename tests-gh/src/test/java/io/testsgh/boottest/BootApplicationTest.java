package io.testsgh.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

@SpringBootTest
public class BootApplicationTest extends AbstractTestNGSpringContextTests {


    @BeforeMethod
    public void setUp1() {

    }

    @DataProvider(name = "Name")
    public static Object[][] Name() {
        return new Object[][]{
            {}
        };
    }

    @Test
    public void testName() {

    }

    @MockBean
    @Autowired
    private UserRepository userRepository;

    @BeforeMethod
    public void setUp() {
        User mockUser = mock(User.class);
        when(mockUser.getLogin()).thenReturn("flash");
        when(mockUser.getPassword()).thenReturn("barry_allen");

        when(userRepository.findById(eq("flash"))).thenReturn(Optional.of(mockUser));
    }

    @Test
    public void testMockBean() {
        assertTrue(userRepository.findById("flash").isPresent());
    }

}