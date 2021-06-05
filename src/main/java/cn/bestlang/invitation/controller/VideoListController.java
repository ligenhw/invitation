package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.model.VideoList;
import cn.bestlang.invitation.repo.VideoListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequestMapping("/invitation/videoList")
@RestController
public class VideoListController {

    @Autowired
    private VideoListRepository videoListRepository;

    @GetMapping("/{videoListId}")
    public VideoList queryVideoList(@PathVariable String videoListId) {
        log.info("queryVideoList videoListId : {}", videoListId);
        Optional<VideoList> videoList = videoListRepository.findById(videoListId);
        return videoList.orElse(null);
    }
}
