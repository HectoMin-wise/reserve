package controller.server.mainmenu.controller.view;

import controller.server.member.entity.Member;

public class MenuImpl implements Menu{

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
    public StringBuilder showLoginForm(int step) {
        StringBuilder sb = new StringBuilder();
        switch (step) {
            case 1:
                sb.append("아이디를 입력해 주세요");
                return sb;
            case 2:
                sb.append("비밀번호를 입력주세요");
                return sb;
            case 99:
                sb.append("로그인 성공!");
                return sb;
            case 404:
                sb.append("아이디나 비밀번호가 틀립니다.!");
                return sb;
        }
        return sb.append("메인으로...");
    }

    @Override
    public StringBuilder showMemberList(Member member) {
//        System.out.println(member);
        StringBuilder sb = new StringBuilder();
        sb.append("아이디 : "+member.getId());
        sb.append(" 닉네임 : "+member.getNickname());
        sb.append(" 가입일 : "+member.getJoinDate());
        return sb;
    }


}
