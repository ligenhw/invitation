package cn.bestlang.invitation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Comment extends AbstractDocument {

    private String topic; // 评论目标 暂时只有wedding
    private UserBaseInfo userBaseInfo;
    private String content;
    @Indexed
    private LocalDateTime time;
}
