package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.api.CommentReq;
import cn.bestlang.invitation.model.Comment;
import cn.bestlang.invitation.security.SimpleSecurityContext;
import cn.bestlang.invitation.service.CommentService;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("/invitation/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{topic}")
    public Page<Comment> queryComment(@PathVariable String topic,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        log.info("queryComment topic : {}", topic);
        return commentService.queryComments(topic, page, size);
    }

    @PostMapping
    public void createComment(@Validated @RequestBody CommentReq commentReq, HttpSession session) {
        log.info("create comment : {}", JsonUtil.toJson(commentReq));
        String userId = SimpleSecurityContext.getAuthentication(session);

        commentService.createComment(userId, commentReq.getTopic(), commentReq.getContent());
    }
}
