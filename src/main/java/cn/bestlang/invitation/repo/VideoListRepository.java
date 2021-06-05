package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.VideoList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoListRepository extends MongoRepository<VideoList, String> {
}
