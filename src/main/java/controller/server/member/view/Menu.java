package controller.server.member.view;

public interface Menu {
    StringBuilder showBanner();
    StringBuilder showMainMenu();
    StringBuilder showJoinForm(int step);
    StringBuilder showLoginForm();
    StringBuilder showMemberList();
}
