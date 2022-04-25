package admin.notice.dao;

import admin.notice.entity.Notice;
import admin.notice.querycontroller.QueryController;
import db.DBConnection;
import db.Ojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao{

    private DBConnection dbConnection = new Ojdbc();
    private Connection conn = dbConnection.getConnection();
    private QueryController qc = new QueryController();

    @Override
    public Long insertNotice(Notice notice) {
        return null;
    }

    @Override
    public List<Notice> getNoticeList(int page) {

        List<Notice> noticeList = new ArrayList<>();

        try {
            String query = "SELECT notice_idx FROM notice";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Notice notice = new Notice();

                notice.setNotice_idx(rs.getLong("notice_idx"));

                noticeList.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return noticeList;
    }

    @Override
    public Notice getNotice(int notice_idx) {
        Notice notice = new Notice();

        try {
            ResultSet rs = qc.selectNotice(conn, notice_idx);

            while (rs.next()) {

                notice.setNotice_idx(rs.getLong("notice_idx"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notice;
    }

    @Override
    public void delNotice(int notice_idx) {

    }

    @Override
    public void hideNotice(int notice_idx) {

    }
}
