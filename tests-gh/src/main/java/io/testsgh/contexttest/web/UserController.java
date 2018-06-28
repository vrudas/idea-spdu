package io.testsgh.contexttest.web;

import io.testsgh.contexttest.User;
import io.testsgh.contexttest.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public void save(User user) {
        userRepository.save(user);
    }

    @GetMapping("/{login}")
    public User get(@PathVariable String login) {
        return userRepository.get(login).orElseThrow(UserNotFoundException::new);
    }

    @DeleteMapping("/{login}")
    public void delete(@PathVariable String login) {
        userRepository.get(login).ifPresent(userRepository::delete);
    }

}
