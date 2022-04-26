package admin.notice.dto;

import admin.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class NoticeDto {
    private Long noticeIdx;
    private Long adminIdx;
    private String title;
    private String contents;
    private int state;
    private Date insDate;
    private Date updDate;
}
