package org.zerock.domain;

import lombok.Data;

import java.util.Date;
@Data
public class BoardVO {
    int bno, count, viewCount;
    String title,content,poster;
    Date regdate;

}
