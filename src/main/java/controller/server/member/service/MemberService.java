package controller.server.member.service;


import controller.server.member.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList(int page);
    Member getMember(Member member);
    Boolean deleteMember(Member member);
    Boolean insertMember(Member member);
    Boolean updateMember(Member member);
}
