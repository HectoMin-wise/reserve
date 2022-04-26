package admin.notice.dao;

import admin.notice.dto.NoticeDto;
import admin.notice.dto.NoticeSearchDto;
import admin.notice.querycontroller.NoticeQuery;
import admin.notice.entity.Notice;

import java.util.List;

public class NoticeDaoImpl implements NoticeDao{

    private NoticeQuery nq = new NoticeQuery();

    @Override
    public Long insertNotice(Notice notice) {
        return null;
    }

    @Override
    public List<NoticeDto> getNoticeList(NoticeSearchDto noticeSearchDto) {
        return nq.selectNoticeList(noticeSearchDto);
    }

    @Override
    public NoticeDto getNotice(int notice_idx) {
        return nq.selectNotice(1);
    }

    @Override
    public void delNotice(int notice_idx) {

    }

    @Override
    public void hideNotice(int notice_idx) {

    }

    @Override
    public void modifyNotice(int notice_idx) {

    }
}
