package admin.member.dao;

import admin.member.entity.Member;

import java.util.List;

public interface MemberDao {
    Long insertMember(Member member);

    List<Member> getMemberList(int page);

    Member getMember(int member_idx);

    void delMember(int member_idx);

    void suspensionMember(int member_idx);
}
