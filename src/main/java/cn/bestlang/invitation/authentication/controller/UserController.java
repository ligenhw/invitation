package cn.bestlang.invitation.authentication.controller;

import cn.bestlang.invitation.authentication.model.User;
import cn.bestlang.invitation.authentication.repo.UserRepository;
import cn.bestlang.invitation.security.SimpleSecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@RequestMapping("/invitation")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User queryUserInfo(HttpSession session) {
        String userId = SimpleSecurityContext.getAuthentication(session);

        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }
}
