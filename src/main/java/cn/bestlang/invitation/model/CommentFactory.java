package cn.bestlang.invitation.model;

import cn.bestlang.invitation.authentication.model.User;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class CommentFactory {

    //TODO : add map struct
    public static Comment createComment(User user, String topic, String content) {
        Comment comment = new Comment();

        UserBaseInfo userBaseInfo = new UserBaseInfo();
        BeanUtils.copyProperties(user, userBaseInfo);
        userBaseInfo.setUserId(user.getId());
        comment.setUserBaseInfo(userBaseInfo);

        comment.setTopic(topic);
        comment.setContent(content);
        comment.setTime(LocalDateTime.now());

        return comment;
    }
}
