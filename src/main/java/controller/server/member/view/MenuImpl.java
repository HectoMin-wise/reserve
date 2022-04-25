package controller.server.member.view;

public class MenuImpl implements Menu{
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
        sb.append("1번 회원가입 \n2번 조회 \n3번 삭제\n4번 비밀번호 변경\n5번 종료");
        return sb;
    }

    @Override
    public StringBuilder showJoinForm(int step) {
        StringBuilder sb = new StringBuilder();
        switch (step) {
            case 1:
                sb.append("아이디를 입력해 주세요");
                return sb;
            case 2:
                sb.append("비밀번호를 입력주세요");
                return sb;
            case 3:
                sb.append("비밀번호를 다시 입력해주세요");
                return sb;
            case 4:
                sb.append("아이디를 다시 입력해 주세요");
                return sb;
            case 5:
                sb.append("처음 입력한 비밀번호와 다릅니다.!");
                return sb;
            case 6:
                sb.append("올바르지 비밀번호 형식입니다.!!\n");
                sb.append("비밀번호를 다시 입력해주세요");
                return sb;
            case 99:
                sb.append("회원가입이 성공적으로 완료되었습니다.!");
                return sb;
        }
        return sb;
    }

    @Override
    public StringBuilder showLoginForm() {
        return null;
    }

    @Override
    public StringBuilder showMemberList() {
        return null;
    }
}
