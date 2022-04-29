package controller.server.mainmenu.view;

import controller.server.member.entity.Member;

public interface Menu {
    StringBuilder showBanner();
    StringBuilder showMainMenu();
    StringBuilder showReserveMenu(Member member);
    StringBuilder showReserveMenuIN();
    StringBuilder showHouseMenu();
}
