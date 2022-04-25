package admin.member.service;

import admin.member.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList(int page);
    Member getMember(int member_idx);
    void delMember(int member_idx);
    void hideMember(int member_idx);
}
