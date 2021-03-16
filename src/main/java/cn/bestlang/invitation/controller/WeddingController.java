package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.model.Wedding;
import cn.bestlang.invitation.repo.WeddingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequestMapping("/invitation/wedding")
@RestController
public class WeddingController {

    @Autowired
    private WeddingRepository weddingRepository;

    @GetMapping("/{weddingId}")
    public Wedding queryWedding(@PathVariable String weddingId) {
        log.info("queryWedding weddingId : {}", weddingId);
        Optional<Wedding> weddingOptional = weddingRepository.findById(weddingId);
        return weddingOptional.orElse(null);
    }
}
