package io.testsgh.contexttest.config;

import io.testsgh.contexttest.storage.InMemoryUserRepository;
import io.testsgh.contexttest.storage.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleContextConfig {

    @Bean
    public UserRepository inMemoryUserRepository() {
        return new InMemoryUserRepository();
    }

}
