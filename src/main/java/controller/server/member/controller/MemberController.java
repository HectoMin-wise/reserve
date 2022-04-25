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

    public void showMainMenu() {
        StringBuilder sb = menu.showBanner().append(menu.showMainMenu());
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }

    public void showJoinForm(int step) {
        StringBuilder sb = menu.showJoinForm(step);
        if (step != 99) {
            sb.append(SETCLIENT);
        }
        pw.println(sb);
        pw.flush();
    }

    public void RecieveData(BufferedReader br, PrintWriter pw, String line) throws InterruptedException, SQLException, IOException {

        MemberController memberController;
        int step = Integer.parseInt(line);
        String data;
        memberController = new MemberController(pw, br, step);
        MemberJoinController memberJoinController = new MemberJoinController();
        boolean joinSuccess = false;
        System.out.println("반복체크" + joinSuccess);
        while (!joinSuccess) {
            memberController.showJoinForm(step);
            data = br.readLine();
            switch (step) {
                case 1:
                case 4:
                    step = memberJoinController.join(data);
                    break;
                case 2:
                case 6:
                    step = memberJoinController.userPasswd(data);
                    break;
                case 3:
                    step = memberJoinController.memberPasswdSameCheck(data);
                    if (step != 99) {
                        break;
                    }
                case 99:
                    memberService.insertMember(memberJoinController.getMember());
                    memberController.showJoinForm(step);
                    joinSuccess = !joinSuccess;
                    System.out.println(step + " " + joinSuccess);
                    break;
                default:
                    break;
            }
        }
    }
}
