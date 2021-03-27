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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("/invitation")
@RestController
public class WxMiniLoginController {

    @Autowired
    private WxMiniLoginService wxMiniLoginService;

    /**
     * spring mvc ServletRequestMethodArgumentResolver 解析 HttpSession httpSession时,
     * 使用 HttpSession session = request.getSession(); 会出发session 创建。
     *
     * 所以此处为了避免函数开始时创建 session,  使用 HttpServletRequest request 作为 参数
     * 最后 成功后才 通过 request.getSession() 创建 session。
     *
     * @param request
     * @param wxMiniLoginReq
     */
    @PostMapping("/login")
    public void login(HttpServletRequest request , @Validated @RequestBody WxMiniLoginReq wxMiniLoginReq) {
        log.info("login wxMiniLoginReq : {}", JsonUtil.toJson(wxMiniLoginReq));

        User user = wxMiniLoginService.login(wxMiniLoginReq);
        SimpleSecurityContext.saveAuthentication(request.getSession(), user.getId());
    }

    @GetMapping("/mlogin/{userId}")
    public void mlogin(HttpSession httpSession, @PathVariable String userId) {
        log.info("mlogin userId : {}", userId);

        SimpleSecurityContext.saveAuthentication(httpSession, userId);
    }
}
