package cn.bestlang.invitation.exception;

public class BusinessException extends RuntimeException {

    private int status; // http status
    private String code; // 错误码
    private String msg; // 错误消息

    public BusinessException(ErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMsg(), args));

        status = errorCode.getStatus();
        code = errorCode.getCode();
        msg = String.format(errorCode.getMsg(), args);
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
