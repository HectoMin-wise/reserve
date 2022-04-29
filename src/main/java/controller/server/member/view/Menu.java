package controller.server.member.view;

import controller.server.member.entity.Member;

import java.util.List;

public interface Menu {
    StringBuilder showJoinForm(int step);
    StringBuilder showLoginForm(int step);
    StringBuilder showMemberList(Member member);
}
