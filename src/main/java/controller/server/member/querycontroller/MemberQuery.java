package controller.server.member.querycontroller;

import controller.server.member.entity.Member;

public interface MemberQuery {
    String insertMember(Member member);
    String getMemberList();
    String getMember(Member member);
    String deleteMember(Member member);
    String updateMember(Member member);
}
