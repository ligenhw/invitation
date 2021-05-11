package cn.bestlang.invitation.controller;

import cn.bestlang.invitation.api.GiftReq;
import cn.bestlang.invitation.model.Gift;
import cn.bestlang.invitation.repo.GiftRepository;
import cn.bestlang.invitation.security.SimpleSecurityContext;
import cn.bestlang.invitation.util.TagUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequestMapping("/invitation/gift")
@RestController
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @GetMapping
    public List<Gift> queryGifts(@RequestParam(defaultValue = TagUtil.RECEIVE) String tag,
                                 HttpSession session) {
        String userId = SimpleSecurityContext.getAuthentication(session);

        log.info("queryGifts tag : {}", tag);
        return giftRepository.findAllByUserIdAndTag(userId, tag);
    }

    @PostMapping
    public void createGift(@Validated @RequestBody GiftReq giftReq, HttpSession session) {
        String userId = SimpleSecurityContext.getAuthentication(session);
        log.info("createGift giftReq : {}", giftReq);

        Gift gift = new Gift();
        BeanUtils.copyProperties(giftReq, gift);
        gift.setUserId(userId);

        giftRepository.insert(gift);
    }

    @DeleteMapping("/{giftId}")
    public void deleteGift(@PathVariable String giftId) {
        giftRepository.deleteById(giftId);
    }
}
