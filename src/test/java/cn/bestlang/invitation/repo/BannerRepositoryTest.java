package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Banner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BannerRepositoryTest {

    @Autowired
    private BannerRepository bannerRepository;

    @Test
    void testQuery() {
        Banner banner = new Banner();
        banner.setUrl("https://xxx.xxx");
        bannerRepository.insert(banner);
    }

}