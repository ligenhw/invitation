package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

    Page<Comment> findAllByTopic(String topic, Pageable var1);
}
