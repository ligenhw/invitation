package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Wedding;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeddingRepository extends MongoRepository<Wedding, String> {

    List<Wedding> findAllByUserId(String userId);
}
