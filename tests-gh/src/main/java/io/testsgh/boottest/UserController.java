package io.testsgh.boottest;

import io.testsgh.contexttest.web.UserNotFoundException;
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
        return userRepository.findById(login).orElseThrow(UserNotFoundException::new);
    }

    @DeleteMapping("/{login}")
    public void delete(@PathVariable String login) {
        userRepository.findById(login).ifPresent(userRepository::delete);
    }

}
