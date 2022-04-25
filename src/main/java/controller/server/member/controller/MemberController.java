package controller.server.member.controller;

import controller.server.member.entity.Member;
import controller.server.member.service.MemberServiceImpl;
import controller.server.member.view.Menu;
import controller.server.member.view.MenuImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberController {
    static private final String SETCLIENT = "\n" + "DATA_SET";
    static private MemberServiceImpl memberService = new MemberServiceImpl();
    static private MenuImpl menu = new MenuImpl();

    private PrintWriter pw;
    private BufferedReader br;
    private int step;

    // TODO: 2022-04-25 show*도 따로 빼줄것!

//    view 만 구현해준다.
    public void showMainMenu() {
        StringBuilder sb = menu.showBanner().append(menu.showMainMenu());
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }
//    step 에 따라서 단계에 맞는 입력 폼을 전송한다.
    public void showJoinForm(int step) {
        StringBuilder sb = menu.showJoinForm(step);
        if (step != 99) {
            sb.append(SETCLIENT);
        }
        pw.println(sb);
        pw.flush();
    }
    public void showMemberList(int page){
//        StringBuilder sb = menu.
    }

//     회원가입 진행
//    step 에 따라서 MemberJoinController의 메소드 실행
//    step은 MemberJoinController의 메소드 리턴값으로 정해짐
    public void joinMember(BufferedReader br, String line) throws IOException {
        int step = Integer.parseInt(line);
        MemberJoinController memberJoinController = new MemberJoinController();
        boolean joinSuccess = false;
        System.out.println("반복체크" + joinSuccess);
        while (!joinSuccess) {
            showJoinForm(step);
            line = br.readLine();
            switch (step) {
                case 1: case 4:
                    step = memberJoinController.join(line);
                    break;
                case 2: case 6:
                    step = memberJoinController.userPasswd(line);
                    break;
                case 3:
                    step = memberJoinController.memberPasswdSameCheck(line);
                    if (step != 99) {
                        break;
                    }
                case 99:
                    memberService.insertMember(memberJoinController.getMember());
                    showJoinForm(step);
                    joinSuccess = !joinSuccess;
                    System.out.println(step + " " + joinSuccess);
                    break;
                default:
                    break;
            }
        }
    }
    public void getMemberList(BufferedReader br, String line){
        memberService.getMemberList(0);
    }


}
