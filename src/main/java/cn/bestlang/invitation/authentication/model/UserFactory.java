package cn.bestlang.invitation.authentication.model;

public class UserFactory {

    public static User createUser(String openid, WxMiniUserInfo wxMiniUserInfo) {
        WxMiniOauthInfo wxMiniOauthInfo = new WxMiniOauthInfo(openid, wxMiniUserInfo);

        User user = new User();
        user.setWxMiniOauthInfo(wxMiniOauthInfo);

        user.setNickName(wxMiniUserInfo.getNickName());
        user.setAvatarUrl(wxMiniUserInfo.getAvatarUrl());
        return user;
    }
}
