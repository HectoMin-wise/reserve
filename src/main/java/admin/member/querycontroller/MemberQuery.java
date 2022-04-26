package admin.member.querycontroller;

import admin.member.dto.MemberDto;
import db.DBConfig;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberQuery {
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

    public List<MemberDto> selectMemberList(int page) {
        List<MemberDto> memberList = new ArrayList<>();

        try {
            String query = "SELECT id, pw, member_idx, nickname, name, phone_number, join_date, leave_date, member_state FROM member";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                MemberDto member = new MemberDto(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getLong("member_idx"),
                        rs.getString("nickname"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getDate("join_date"),
                        rs.getDate("leave_date"),
                        rs.getLong("member_state")
                );

                memberList.add(member);
            }

            this.closeCSR();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;
    }

    public MemberDto selectMember(int member_idx) {
        MemberDto member = null;

        try {
            String query = "SELECT id, pw, member_idx, nickname, name, phone_number, join_date, leave_date, member_state FROM member WHERE member_idx = ?";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, member_idx);

            rs = stmt.executeQuery();

            if (rs.next()) {
                member = new MemberDto(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getLong("member_idx"),
                        rs.getString("nickname"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getDate("join_date"),
                        rs.getDate("leave_date"),
                        rs.getLong("member_state")
                );
            }

            this.closeCSR();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    public void updateMemberState(int member_idx, int state) {

        try {
            String query = "UPDATE member SET member_state = ? WHERE member_idx = ?";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, state);
            stmt.setInt(2, member_idx);

            int i = stmt.executeUpdate();

            this.closeCS();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
