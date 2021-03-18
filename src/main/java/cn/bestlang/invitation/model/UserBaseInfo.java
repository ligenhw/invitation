package cn.bestlang.invitation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserBaseInfo {
    private String userId; // id
    private String nickName; // 昵称
    private String avatarUrl; // 头像
}
