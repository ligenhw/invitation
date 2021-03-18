package cn.bestlang.invitation.authentication.repo;

import cn.bestlang.invitation.authentication.model.User;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
    }

    @Test
    void findByOpenId() {

        User user = userRepository.findByOpenId("123");
        log.info(JsonUtil.toJson(user));
    }
}