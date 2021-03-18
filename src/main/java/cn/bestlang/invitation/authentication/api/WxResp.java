package cn.bestlang.invitation.authentication.api;

import cn.bestlang.invitation.exception.BusinessException;
import cn.bestlang.invitation.exception.ErrorCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class WxResp {
    private String errcode;
    private String errmsg;

    public void checkAndThrow() {
        if (errcode != null && !errcode.equals("0")) {
            String message = "errCode : " + errcode + ", errmsg :" + errmsg;
            log.error("wx response : " + message);
            throw new BusinessException(ErrorCode.LOGIN_ERROR, message);
        }
    }
}
