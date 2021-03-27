package cn.bestlang.invitation.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties={
        "spring.autoconfigure.exclude=" +
                "org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration," +
                "org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration" +
                "org.springframework.boot.autoconfigure.session.SessionAutoConfiguration"
})
@SpringBootTest
public class BaseTest {
}
