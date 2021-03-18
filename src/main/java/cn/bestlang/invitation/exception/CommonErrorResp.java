package cn.bestlang.invitation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonErrorResp {
    private String code; // 错误码
    private String msg; // 错误消息
}
