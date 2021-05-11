package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.base.BaseTest;
import cn.bestlang.invitation.model.Gift;
import cn.bestlang.invitation.util.TagUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class GiftRepositoryTest extends BaseTest {

    @Autowired
    private GiftRepository giftRepository;

    @Test
    void save() {
        Gift gift = new Gift();
        gift.setUserId("2");
        gift.setTag(TagUtil.RECEIVE);

        gift.setName("张某");
        gift.setAmount(1000);
        gift.setDate(LocalDate.now());

        giftRepository.save(gift);
    }
}
