package controller.server.member.dao;

import controller.server.DbConnection;
import controller.server.member.entity.Member;
import controller.server.member.querycontroller.MemberQueryImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
    // TODO: 2022-04-25 sql 문자열 입력 받는 장소
    static MemberQueryImpl memberQuery = new MemberQueryImpl();
    static DbConnection dbConnection = new DbConnection();
    @Override
    public Long insertMember(Member member) {
        System.out.println("호출 체크 디에이오");
        try {
            Statement statement = dbConnection.getCon().createStatement();
            System.out.println(memberQuery.insertMember(member));
            return Long.valueOf(statement.executeUpdate(memberQuery.insertMember(member)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public List<Member> getMemberList(int page) {
        return null;
    }

    @Override
    public Member getMember(Member member) {
        return null;
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
