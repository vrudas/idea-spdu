package io.testsgh.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
//@ActiveProfiles("dev")
public class ProfilesTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProfileComponent profileComponent;

    @Test
    public void testProfileComponent() {
        assertEquals(profileComponent.getMessage(), "TEST_PROFILE");
//        assertEquals(profileComponent.getMessage(), "DEV_PROFILE");
    }
}
