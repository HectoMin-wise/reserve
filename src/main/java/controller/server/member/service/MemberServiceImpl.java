package controller.server.member.service;

import controller.server.member.dao.MemberDaoImpl;
import controller.server.member.entity.Member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    public MemberDaoImpl dao = new MemberDaoImpl();

    @Override
    public List<Member> getMemberList(int page) {
        return dao.getMemberList(page);
    }

    @Override
    public Member getMember(Member member) {
        return dao.getMember(member);
    }

    @Override
    public Boolean deleteMember(Member member) {
        return 1==dao.deleteMember(member);
    }

    @Override
    public Boolean insertMember(Member member) {
        return 1==dao.insertMember(member);
    }

    @Override
    public Boolean updateMember(Member member) {
        return 1==dao.updateMember(member);
    }
}
