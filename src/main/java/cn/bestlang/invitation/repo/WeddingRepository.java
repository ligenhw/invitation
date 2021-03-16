package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Wedding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeddingRepository extends MongoRepository<Wedding, String> {
}
