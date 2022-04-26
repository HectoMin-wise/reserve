package admin.notice.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeSearchDto {
    private String author;
    private String title;
    private String contents;
    private int state;
    private Date insDate;
    private Date updDate;
}
