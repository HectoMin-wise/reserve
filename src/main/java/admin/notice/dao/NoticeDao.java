package admin.notice.dao;

import admin.notice.entity.Notice;

import java.util.List;

public interface NoticeDao {
    Long insertNotice(Notice notice);

    List<Notice> getNoticeList(int page);

    Notice getNotice(int notice_idx);

    void delNotice(int notice_idx);

    void hideNotice(int notice_idx);
}
