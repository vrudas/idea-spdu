package io.testsgh.contexttest.storage;

import io.testsgh.contexttest.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> storage = new HashMap<>();

    @Override
    public void save(User user) {
        storage.put(user.getLogin(), user);
    }

    @Override
    public Optional<User> get(String login) {
        return Optional.ofNullable(storage.get(login));
    }

    @Override
    public void delete(User user) {
        storage.remove(user.getLogin());
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    public StorageType repositoryType() {
        return StorageType.IN_MEMORY;
    }
}
