package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.model.Wedding;
import cn.bestlang.invitation.repo.WeddingRepository;
import cn.bestlang.invitation.security.SimpleSecurityContext;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
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

    @PostMapping
    public void createWedding(@RequestBody Wedding wedding, HttpSession session) {
        String userId = SimpleSecurityContext.getAuthentication(session);

        // 忽略输入id
        wedding.setId(null);
        wedding.setUserId(userId);
        log.info("create wedding : {}", JsonUtil.toJson(wedding));
        weddingRepository.insert(wedding);
    }

    @GetMapping
    public List<Wedding> queryUserWedding(HttpSession session) {
        String userId = SimpleSecurityContext.getAuthentication(session);

        return weddingRepository.findAllByUserId(userId);
    }
}
