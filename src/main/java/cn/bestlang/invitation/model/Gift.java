package cn.bestlang.invitation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Gift extends AbstractDocument {

    @Indexed
    private String userId;
    @Indexed
    private String tag; // receive, send

    private String name;
    private Integer amount;
    private LocalDate date;
    private String note;
}
