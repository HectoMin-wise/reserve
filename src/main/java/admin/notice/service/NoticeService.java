package admin.notice.service;

import admin.notice.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList(int page);
    Notice getNotice(int notice_idx);
    void delNotice(int notice_idx);
    void hideNotice(int notice_idx);
}
