package cn.bestlang.invitation.authentication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;

    private String nickName; // 昵称
    private String avatarUrl; // 头像

    private WxMiniOauthInfo wxMiniOauthInfo; // 微信小程序 授权信息 包括 openid 和 userInfo
}
