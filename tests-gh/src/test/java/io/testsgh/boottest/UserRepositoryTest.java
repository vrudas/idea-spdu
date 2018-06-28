package io.testsgh.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.testng.Assert.assertTrue;

@SpringBootTest
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCrud() {
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());

        assertTrue(users.isEmpty());

        userRepository.save(createUser("batman", "bruce_wayne"));

        assertTrue(userRepository.findById("batman").isPresent());
    }

    private User createUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}