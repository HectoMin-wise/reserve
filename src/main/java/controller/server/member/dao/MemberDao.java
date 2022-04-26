package controller.server.member.dao;

import controller.server.member.entity.Member;

import java.util.List;

public interface MemberDao {
    Long insertMember(Member member);
    List<Member> getMemberList(int page);
    Member getMember(Member member);
    Long deleteMember(Member member);
    Long updateMember(Member member);
}
