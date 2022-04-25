package controller.server.member.controller;

import controller.server.member.entity.Member;
import controller.server.member.service.MemberServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
    static public MemberServiceImpl memberService = new MemberServiceImpl();

    // TODO: 2022-04-25 삭제 필 테스트용 메인 함수
    public static void main(String[] args) {
        Member member = new Member();
//        member.setMemberIdx();
        member.setMemberState(1L);
        member.setId("testMemberId");
        member.setNickname("king왕짱");
//        member.setJoinDate("");
//        member.setLeaveDate();
        member.setName("김성민");
        member.setPw("1q2w3e4r!");
        member.setPhoneNumber("010-5098-2039");
//        Boolean i = memberService.insertMember(member);
//        System.out.println(i+"삽입 완료");
        List<Member> memberList;
        memberList = memberService.getMemberList(0);
        for (Member member1: memberList) {
            System.out.println(member1);
        }
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i));
        }
    }
}
