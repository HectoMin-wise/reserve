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


//    step 에 따라서 단계에 맞는 입력 폼을 전송한다.
    public void showJoinForm(int step) {
        StringBuilder sb = menu.showJoinForm(step);
        if (step != 99) {
            sb.append(SETCLIENT);
        }
        pw.println(sb);
        pw.flush();
    }
    public void showLoginForm(int step){
        StringBuilder sb = menu.showLoginForm(step);
        if (step == 99 || step ==404) {
        }else {
            sb.append(SETCLIENT);
        }
        pw.println(sb);
        pw.flush();
    }

    public Member loginMember(BufferedReader br, String line) throws  IOException{
        Member member = new Member();
        int step = 1;
        boolean loginSuccess = false;
        while (!loginSuccess) {
            showLoginForm(step);
            line = br.readLine();
            if(line.equals("exit")) {
                showLoginForm(100);
                member.setId("NOTLOGIN");
                loginSuccess=true;
            }
            switch (step) {
                case 1:
                    step++;
                    member.setId(line);
                    break;
                case 2:
                    step--;
                    member.setPw(line);
                    try {
                        loginSuccess = memberService.getMember(member).getId().equals(member.getId()) ? true : false;
                    }catch (Exception e)
                    {
                        loginSuccess=false;
                        showLoginForm(404);
                    }
                    if (loginSuccess)
                    {
                        step=99;
                        showLoginForm(step);
                        return member;
                    }
            }
        }
        return member;
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
        List<Member> memberList = memberService.getMemberList(0);
        StringBuilder sb = new StringBuilder();
        for (Member member: memberList) {
            sb = menu.showMemberList(member);
            pw.println(sb);
            pw.flush();
        }
        pw.println(SETCLIENT);
        pw.flush();
    }
}
