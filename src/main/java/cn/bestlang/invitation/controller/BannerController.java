package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.model.Banner;
import cn.bestlang.invitation.repo.BannerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/invitation/banner")
@RestController
public class BannerController {

    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping
    public List<Banner> queryBanner() {
        return bannerRepository.findAll();
    }
}
