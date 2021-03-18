package cn.bestlang.invitation.service;

import cn.bestlang.invitation.authentication.model.User;
import cn.bestlang.invitation.authentication.repo.UserRepository;
import cn.bestlang.invitation.model.Comment;
import cn.bestlang.invitation.model.CommentFactory;
import cn.bestlang.invitation.repo.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    public Page<Comment> queryComments(String topic, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Comment> commentPage = commentRepository.findAllByTopic(topic, pageRequest);

        return commentPage;
    }

    public void createComment(String userId, String topic, String content) {
        User user = userRepository.findById(userId).get();

        Comment comment = CommentFactory.createComment(user, topic, content);
        commentRepository.insert(comment);
    }
}
