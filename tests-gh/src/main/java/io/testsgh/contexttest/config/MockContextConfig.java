package io.testsgh.contexttest.config;

import io.testsgh.contexttest.storage.InMemoryUserRepository;
import io.testsgh.contexttest.storage.StorageType;
import io.testsgh.contexttest.storage.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@Configuration
public class MockContextConfig {

    @Bean
    public UserRepository inMemoryUserRepository() {
        InMemoryUserRepository inMemoryUserRepository = spy(new InMemoryUserRepository());

        doReturn(StorageType.DB).when(inMemoryUserRepository).repositoryType();

        return inMemoryUserRepository;
    }

}
