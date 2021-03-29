package cn.bestlang.invitation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Wedding extends AbstractDocument {

    private String userId; // 创建者用户id

    private Person groom; // 新郎
    private Person bride; // 新娘
    private String time; // 时间
    private Address address; // 地点

    private Poster poster; // 海报
    private List<String> album; // 相册
    private Audio audio; // 音频
}
