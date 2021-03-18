package cn.bestlang.invitation.authentication.model;

import lombok.Data;

@Data
public class WxMiniUserInfo {
    private String nickName;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
}
