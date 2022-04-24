package admin.notice.dto;

import admin.notice.entity.Notice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NoticeDto {
    private List<Notice> noticeList;
    private Notice Notice;
}
