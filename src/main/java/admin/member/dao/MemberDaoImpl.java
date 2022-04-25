package admin.member.dao;

import admin.member.entity.Member;
import admin.member.querycontroller.QueryController;

import java.util.List;

public class MemberDaoImpl implements MemberDao{

    private QueryController qc = new QueryController();

    @Override
    public Long insertMember(Member member) {
        return null;
    }

    @Override
    public List<Member> getMemberList(int page) {
        return qc.selectMemberList(page);
    }

    @Override
    public Member getMember(int member_idx) {
        return qc.selectMember(member_idx);
    }

    @Override
    public void delMember(int member_idx) {

    }

    @Override
    public void suspensionMember(int member_idx) {

    }
}
