package cn.bestlang.invitation.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GiftReq {
    private String tag; // receive, send

    private String name;
    private Integer amount;
    private LocalDate date;
    private String note;
}
