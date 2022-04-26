package admin.member.service;

import admin.member.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList(int page);
    Member getMember(int memberIdx);
    void delMember(int memberIdx);
    void hideMember(int memberIdx);
    String getMemberListString();
    String getMemberString(int memberIdx);
}
