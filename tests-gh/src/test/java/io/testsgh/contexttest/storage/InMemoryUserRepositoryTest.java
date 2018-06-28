package io.testsgh.contexttest.storage;

import io.testsgh.contexttest.config.MockContextConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//@ContextConfiguration(classes = SimpleContextConfig.class)
@ContextConfiguration(classes = MockContextConfig.class)
public class InMemoryUserRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testContextInitialized() {

    }

    @Test
    public void testRepositoryType() {
//        assertEquals(userRepository.repositoryType(), StorageType.IN_MEMORY);
        assertEquals(userRepository.repositoryType(), StorageType.DB);
    }

}