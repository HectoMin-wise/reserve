package controller.server.member.querycontroller;

import controller.server.member.entity.Member;

public class MemberQueryImpl implements MemberQuery{
    @Override
    public String insertMember(Member member) {
        return "INSERT INTO member(member_idx, id, pw, nickname," +
                " name, phone_number, join_date, leave_date, member_state)\r\n"
                +" VALUES(member_idx_seq.NEXTVAL, '"+member.getId()+"', '"+member.getPw()+"', '"+member.getNickname()+"', '"
                +member.getName()+"', '"+member.getPhoneNumber()+"', SYSDATE, null, "+member.getMemberState()+")";
    }

    @Override
    public String getMemberList() {
        return "SELECT member_idx, id, pw, nickname,"
                +" name, phone_number, join_date, leave_date, member_state\r\n" +
                " FROM member";
    }

    @Override
    public String getMember(Member member) {
        return null;
    }

    @Override
    public String deleteMember(Member member) {
        return null;
    }

    @Override
    public String updateMember(Member member) {
        return null;
    }
}
