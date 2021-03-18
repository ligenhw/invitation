package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Comment;
import cn.bestlang.invitation.model.UserBaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void save() {
        UserBaseInfo userBaseInfo = new UserBaseInfo("1", "nikeName",  "img");

        Comment comment = new Comment();
        comment.setTopic("1");
        comment.setTime(LocalDateTime.now());
        comment.setContent("祝福");
        comment.setUserBaseInfo(userBaseInfo);
        commentRepository.insert(comment);
    }

    @Test
    void batchSave() {
        for (int i = 0; i < 20; i++) {
            savei(i);
        }
    }

    void savei(int i) {
        UserBaseInfo userBaseInfo = new UserBaseInfo("1", "nikeName",  "img");

        Comment comment = new Comment();
        comment.setTopic("1");
        comment.setTime(LocalDateTime.now());
        comment.setContent("祝福 " + i);
        comment.setUserBaseInfo(userBaseInfo);
        commentRepository.insert(comment);
    }
}