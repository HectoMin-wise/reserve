package admin.member.dao;

import admin.member.entity.Member;
import admin.member.querycontroller.QueryController;
import db.DBConnection;
import db.Ojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao{

    private DBConnection dbConnection = new Ojdbc();
    private Connection conn = dbConnection.getConnection();
    private QueryController qc = new QueryController();

    @Override
    public Long insertMember(Member member) {
        return null;
    }

    @Override
    public List<Member> getMemberList(int page) {

        List<Member> memberList = new ArrayList<>();

        try {
            String query = "SELECT member_idx FROM member";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Member member = new Member();

                member.setMember_idx(rs.getLong("member_idx"));

                memberList.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;
    }

    @Override
    public Member getMember(int member_idx) {
        Member member = new Member();

        try {
            ResultSet rs = qc.selectMember(conn, member_idx);

            while (rs.next()) {

                member.setMember_idx(rs.getLong("member_idx"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    @Override
    public void delMember(int member_idx) {

    }

    @Override
    public void suspensionMember(int member_idx) {

    }
}
