package io.testsgh.contexttest.storage;

import io.testsgh.contexttest.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> get(String login);

    void delete(User user);

    void deleteAll();

    StorageType repositoryType();

}
