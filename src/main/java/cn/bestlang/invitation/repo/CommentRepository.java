package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

    /**
     *
     * spring data 源码 org.springframework.data.repository.query.parser.PartTree.java
     * 解析方法名， 内部类 Predicate 分割排序时 使用 "OrderBy" ，而不是文档中的 "SortBy"
     *
     * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries.sort
     *
     *
     *
     * @param topic
     * @param var1
     * @return
     */
    Page<Comment> findAllByTopicOrderByTimeDesc(String topic, Pageable var1);
}
