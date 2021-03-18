package cn.bestlang.invitation.authentication.service;

import cn.bestlang.invitation.authentication.api.AuthCode2SessionResp;
import cn.bestlang.invitation.authentication.api.WxApi;
import cn.bestlang.invitation.authentication.model.*;
import cn.bestlang.invitation.authentication.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WxMiniLoginService {

    @Autowired
    private WxApi wxApi;
    @Autowired
    private UserRepository userRepository;

    public User login(WxMiniLoginReq wxMiniLoginReq) {

        AuthCode2SessionResp authCode2SessionResp = wxApi.code2Session(wxMiniLoginReq.getCode());

        String openid = authCode2SessionResp.getOpenid();
        User user = findOrCreateUser(openid, wxMiniLoginReq.getUserInfo());

        return user;
    }

    private User findOrCreateUser(String openid, WxMiniUserInfo wxMiniUserInfo) {
        User user = userRepository.findByOpenId(openid);

        if (user == null) {
            user = UserFactory.createUser(openid, wxMiniUserInfo);
        }

        return user;
    }


}
