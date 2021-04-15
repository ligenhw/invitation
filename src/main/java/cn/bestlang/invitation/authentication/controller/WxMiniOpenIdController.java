package cn.bestlang.invitation.authentication.controller;

import cn.bestlang.invitation.authentication.api.AuthCode2SessionResp;
import cn.bestlang.invitation.authentication.api.WxApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/invitation")
@RestController
public class WxMiniOpenIdController {

    @Autowired
    private WxApi wxApi;

    @GetMapping("/openId")
    public AuthCode2SessionResp queryOpenId(String code) {
        return wxApi.code2Session(code);
    }
}
