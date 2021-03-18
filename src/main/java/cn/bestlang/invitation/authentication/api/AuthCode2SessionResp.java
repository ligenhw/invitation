package cn.bestlang.invitation.authentication.api;

import lombok.Data;

@Data
public class AuthCode2SessionResp extends WxResp {
    private String openid;
    private String session_key;
}
