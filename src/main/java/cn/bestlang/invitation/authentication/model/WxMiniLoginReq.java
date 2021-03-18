package cn.bestlang.invitation.authentication.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WxMiniLoginReq {

    @NotBlank
    private String code;
    @NotNull
    private WxMiniUserInfo userInfo;
}
