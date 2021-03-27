package cn.bestlang.invitation.authentication.repo;

import cn.bestlang.invitation.authentication.model.User;
import cn.bestlang.invitation.authentication.model.UserFactory;
import cn.bestlang.invitation.authentication.model.WxMiniUserInfo;
import cn.bestlang.invitation.base.BaseTest;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        WxMiniUserInfo wxMiniUserInfo = new WxMiniUserInfo();
        wxMiniUserInfo.setNickName("gen");
        User user = UserFactory.createUser("123", wxMiniUserInfo);

        userRepository.insert(user);
    }

    @Test
    void findByOpenId() {

        User user = userRepository.findByOpenId("123");
        log.info(JsonUtil.toJson(user));
    }
}