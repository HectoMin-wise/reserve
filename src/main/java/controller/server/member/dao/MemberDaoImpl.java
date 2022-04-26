package controller.server.member.dao;

import controller.server.member.entity.Member;
import controller.server.member.querycontroller.MemberQueryImpl;
import db.DBConfig;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
    // TODO: 2022-04-25 sql 문자열 입력 받는 장소
    static MemberQueryImpl memberQuery = new MemberQueryImpl();
    private DBConnection dbConnection = DBConfig.getDbInstance();
    private Connection con;
    @Override
    public Long insertMember(Member member) {
        System.out.println("호출 체크 DAO");
        try {
            con = dbConnection.getConnection();
            Statement statement = con.createStatement();
            System.out.println(memberQuery.insertMember(member));
            statement.close();
            con.close();
            return Long.valueOf(statement.executeUpdate(memberQuery.insertMember(member)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
//  member의 데이터는 9개! 기본적으로 미표기는 String
//     member_idx(Number), id, pw, nickname, name, phone_number, join_date(Date),
//    leave_date(Date), member_state(Number)
    @Override
    public List<Member> getMemberList(int page) {
        List<Member> memberList = new ArrayList<>();
        try {
            con = dbConnection.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(memberQuery.getMemberList());
            while (rs.next()){
                Member member = new Member();
                member.setMemberIdx(rs.getLong(1));
                member.setId(rs.getString(2));
                member.setPw(rs.getString(3));
                member.setNickname(rs.getString(4));
                member.setName(rs.getString(5));
                member.setPhoneNumber(rs.getString(6));
                member.setJoinDate(rs.getDate(7));
                member.setLeaveDate(rs.getDate(8));
                member.setMemberState(rs.getLong(9));
//                System.out.println(member);
                memberList.add(member);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;
    }

    @Override
    public Member getMember(Member member) {
        Member member1 = new Member();
        Statement statement = null;
        try {
            con = dbConnection.getConnection();
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(memberQuery.getMember(member));
            if (rs.next()) {
                member1.setId(rs.getString(1));
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member1;
    }

    @Override
    public Long deleteMember(Member member) {
        return null;
    }

    @Override
    public Long updateMember(Member member) {
        return null;
    }
}
