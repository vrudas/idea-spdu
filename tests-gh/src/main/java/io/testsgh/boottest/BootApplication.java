package io.testsgh.boottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(scanBasePackages = "io.testsgh.boottest")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Bean
    @Profile("test")
    public ProfileComponent testProfileComponent() {
        return () -> "TEST_PROFILE";
    }

    @Bean
    @Profile("dev")
    public ProfileComponent devProfileComponent() {
        return () -> "DEV PROFILE";
    }
}
