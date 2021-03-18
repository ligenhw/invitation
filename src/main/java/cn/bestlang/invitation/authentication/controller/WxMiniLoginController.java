package cn.bestlang.invitation.authentication.controller;

import cn.bestlang.invitation.authentication.model.User;
import cn.bestlang.invitation.authentication.model.WxMiniLoginReq;
import cn.bestlang.invitation.authentication.service.WxMiniLoginService;
import cn.bestlang.invitation.security.SimpleSecurityContext;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("/invitation")
@RestController
public class WxMiniLoginController {

    @Autowired
    private WxMiniLoginService wxMiniLoginService;

    @PostMapping("/login")
    public void login(HttpSession httpSession, @Validated @RequestBody WxMiniLoginReq wxMiniLoginReq) {
        log.info("login wxMiniLoginReq : {}", JsonUtil.toJson(wxMiniLoginReq));

        User user = wxMiniLoginService.login(wxMiniLoginReq);
        SimpleSecurityContext.saveAuthentication(httpSession, user.getId());
    }

    @GetMapping("/mlogin/{userId}")
    public void mlogin(HttpSession httpSession, @PathVariable String userId) {
        log.info("mlogin userId : {}", userId);

        SimpleSecurityContext.saveAuthentication(httpSession, userId);
    }
}
