package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Banner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BannerRepository extends MongoRepository<Banner, String> {
}
