package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Gift;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GiftRepository extends MongoRepository<Gift, String> {

    List<Gift> findAllByUserIdAndTag(String userId, String tag);
}
