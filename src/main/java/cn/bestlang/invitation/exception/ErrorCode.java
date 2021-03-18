package cn.bestlang.invitation.exception;

public enum ErrorCode {

    LOGIN_ERROR(400, "LOGIN_ERROR", "登陆失败 : %s")
    ;

    private int status; // http status
    private String code; // 错误码
    private String msg; // 错误消息

    ErrorCode(int status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
