package controller.server.mainmenu.view;


import controller.server.member.entity.Member;

public class MenuImpl implements Menu {
    @Override
    public StringBuilder showReserveMenuIN() {
        StringBuilder sb = new StringBuilder();
        sb.append("1번 예약목록 조회 \n2번 예약취소\n3번 뒤로가기");
        return sb;
    }

    @Override
    public StringBuilder showReserveMenu(Member member) {
        StringBuilder sb = new StringBuilder();
        sb.append("환영합니다.! "+member.getId()+" 회원님 메뉴를 선택해 주세요.!\n");
        sb.append("1번 예약관리 \n2번 숙소찾기\n3번 로그아웃");
        return sb;
    }

    @Override
    public StringBuilder showHouseMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1번 숙소목록 조회 \n2번 숙소상세\n3번 숙소 예약하기\n4번 뒤로가기");
        return sb;
    }

    @Override
    public StringBuilder showBanner() {
        StringBuilder sb = new StringBuilder();

        sb.append(" ___  ___  _______   ________ _________  ________     \n");
        sb.append("|\\  \\|\\  \\|\\  ___ \\ |\\   ____\\\\___   ___\\\\   __  \\    \n");
        sb.append("\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\___\\|___ \\  \\_\\ \\  \\|\\  \\   \n");
        sb.append(" \\ \\   __  \\ \\  \\_|/_\\ \\  \\       \\ \\  \\ \\ \\  \\\\\\  \\  \n");
        sb.append("  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____   \\ \\  \\ \\ \\  \\\\\\  \\ \n");
        sb.append("   \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\ \\ \\_______\\\n");
        sb.append("    \\|__|\\|__|\\|_______|\\|_______|   \\|__|  \\|_______|\n");
        return sb;
    }

    @Override
    public StringBuilder showMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("안녕하세요?\n");
        sb.append("1번 회원가입 \n2번 로그인");
        return sb;
    }

}
