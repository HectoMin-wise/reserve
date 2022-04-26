package admin.notice.dao;

import admin.notice.dto.NoticeDto;
import admin.notice.dto.NoticeSearchDto;
import admin.notice.entity.Notice;

import java.util.List;

public interface NoticeDao {
    Long insertNotice(Notice notice);

    List<NoticeDto> getNoticeList(NoticeSearchDto noticeSearchDto);

    NoticeDto getNotice(int notice_idx);

    void delNotice(int notice_idx);

    void hideNotice(int notice_idx);

    void modifyNotice(int notice_idx);
}
