package cn.bestlang.invitation.authentication.repo;

import cn.bestlang.invitation.authentication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'wxMiniOauthInfo.openId' : ?0 }")
    User findByOpenId(String openId);
}
