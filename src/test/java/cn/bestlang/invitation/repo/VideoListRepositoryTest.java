package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.base.BaseTest;
import cn.bestlang.invitation.model.VideoList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class VideoListRepositoryTest extends BaseTest {

    @Autowired
    private VideoListRepository videoListRepository;

    @Test
    void save() {
        VideoList videoList = new VideoList();
        videoList.setTitle("test");

        videoListRepository.save(videoList);
    }
}