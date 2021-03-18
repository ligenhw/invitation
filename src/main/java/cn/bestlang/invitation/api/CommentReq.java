package cn.bestlang.invitation.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentReq {

    private String topic; // 评论目标 使用 weddingId
    @NotBlank
    private String content;
}
