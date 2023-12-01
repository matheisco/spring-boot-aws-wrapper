package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    @Transactional(readOnly = true)
    public String endpoint() {
        User user = userRepository.findById(1).get();
        return user.getData();
    }
}
