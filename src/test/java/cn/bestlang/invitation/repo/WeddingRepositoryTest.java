package cn.bestlang.invitation.repo;

import cn.bestlang.invitation.model.Address;
import cn.bestlang.invitation.model.Person;
import cn.bestlang.invitation.model.Poster;
import cn.bestlang.invitation.model.Wedding;
import cn.bestlang.invitation.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class WeddingRepositoryTest {

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

        wedding.setAudio("http://music.163.com/song/media/outer/url?id=1826162791.mp3");

        Wedding weddingResult = weddingRepository.insert(wedding);

        log.info(JsonUtil.toJson(weddingResult));
    }
}