package cn.bestlang.invitation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class VideoList extends AbstractDocument {

    private String title;
    private List<Video> videos;
}
