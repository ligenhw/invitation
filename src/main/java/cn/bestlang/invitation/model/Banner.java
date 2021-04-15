package cn.bestlang.invitation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Banner extends AbstractDocument {

    private String url;
}
