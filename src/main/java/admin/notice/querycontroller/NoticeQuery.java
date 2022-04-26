package admin.notice.querycontroller;

import admin.function.SearchFunction;
import admin.notice.dto.NoticeDto;
import admin.notice.dto.NoticeSearchDto;
import admin.notice.entity.Notice;
import db.DBConfig;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeQuery {
    private final DBConnection dbConnection = DBConfig.getDbInstance();
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private void closeCSR() throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }

    private void closeCS() throws SQLException {
        stmt.close();
        conn.close();
    }

    public List<NoticeDto> selectNoticeList(NoticeSearchDto noticeSearchDto) {
        List<NoticeDto> noticeList = new ArrayList<>();
//        if (noticeSearchDto.getAuthor().isEmpty())
        StringBuilder query_ = new StringBuilder("SELECT notice_idx, admin_idx, title, contents, state, ins_date, upd_date FROM notice WHERE state = 1");

        if(!SearchFunction.isEmptyOrNull(noticeSearchDto.getAuthor())){
            query_.append(" AND admin_idx = (SELECT admin_idx FROM admin WHERE nickname = "+noticeSearchDto.getAuthor()+")");
        }


        try {
            String query = "SELECT notice_idx, admin_idx, title, contents, state, ins_date, upd_date FROM notice WHERE state = 1";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                NoticeDto notice = new NoticeDto(
                        rs.getLong("notice_idx"),
                        rs.getLong("admin_idx"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getInt("state"),
                        rs.getDate("ins_date"),
                        rs.getDate("upd_date")
                );

                noticeList.add(notice);
            }

            this.closeCSR();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return noticeList;
    }

    public NoticeDto selectNotice(int notice_idx) {
        NoticeDto notice = null;

        try {
            String query = "SELECT notice_idx, admin_idx, title, contents, state, ins_date, upd_date FROM notice WHERE state = 1 AND notice_idx = ?";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, notice_idx);

            rs = stmt.executeQuery();

            if (rs.next()) {
                notice = new NoticeDto(
                        rs.getLong("notice_idx"),
                        rs.getLong("admin_idx"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getInt("state"),
                        rs.getDate("ins_date"),
                        rs.getDate("upd_date")
                );
            }

            this.closeCSR();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notice;
    }

    public void updateNoticeState(int notice_idx, int state) {

        try {
            String query = "UPDATE notice SET notice_state = ? WHERE notice_idx = ?";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, state);
            stmt.setInt(2, notice_idx);

            int i = stmt.executeUpdate();

            this.closeCS();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
