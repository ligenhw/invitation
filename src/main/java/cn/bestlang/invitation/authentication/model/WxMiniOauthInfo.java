package cn.bestlang.invitation.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WxMiniOauthInfo {

    private String openId;
    private WxMiniUserInfo wxMiniUserInfo;
}
