package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.base.BaseTest;
import cn.bestlang.invitation.model.*;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class WeddingRepositoryTest extends BaseTest {

    @Autowired
    private WeddingRepository weddingRepository;

    @Test
    void save() {
        Wedding wedding = new Wedding();

        Person groom = new Person();
        groom.setName("李某某");
        groom.setTel("13888888888");
        wedding.setGroom(groom);

        Person bride = new Person();
        bride.setName("周某某");
        bride.setTel("13988888888");
        wedding.setBride(bride);

        wedding.setTime("2021-05-0x");

        Poster poster = new Poster();
        poster.setImg("http://oss.bestlang.cn/invitation/user/1/CR2A7075.jpg");
        poster.setWelcome("欢迎各位莅临!");
        wedding.setPoster(poster);

        Address address = new Address();
        address.setLatitude(40.457258f);
        address.setLongitude(124.066391f);
        address.setText("xx省xx市xx宾馆");
        wedding.setAddress(address);

        List<String> album = new ArrayList<>();
        album.add("http://oss.bestlang.cn/invitation/user/1/CR2A7075.jpg");
        album.add("http://oss.bestlang.cn/invitation/user/1/CR2A7075.jpg");
        wedding.setAlbum(album);

        Audio audio = new Audio();
        audio.setName("今天你要嫁给我");
        audio.setUrl("http://music.163.com/song/media/outer/url?id=5254811.mp3");
        wedding.setAudio(audio);

        Wedding weddingResult = weddingRepository.insert(wedding);

        log.info(JsonUtil.toJson(weddingResult));
    }
}