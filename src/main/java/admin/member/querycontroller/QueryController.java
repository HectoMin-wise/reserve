package admin.member.querycontroller;

import admin.member.entity.Member;
import db.DBConfig;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryController {
    private DBConnection dbConnection = DBConfig.getDbInstance();
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public List<Member> selectMemberList(int page) {
        List<Member> memberList = new ArrayList<>();

        try {
            String query = "SELECT member_idx FROM member";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Member member = new Member();

                member.setMember_idx(rs.getLong("member_idx"));

                memberList.add(member);
            }

            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;
    }

    public Member selectMember(int member_idx) {
        Member member = new Member();

        try {
            String query = "SELECT member_idx FROM member WHERE member_idx = ?";

            conn = dbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(0, member_idx);

            rs = stmt.executeQuery();

            member.setMember_idx(rs.getLong("member_idx"));

            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    private void closeAll() throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }
}
