package controller.server.member.controller;

import controller.server.member.entity.Member;
import controller.server.member.service.MemberServiceImpl;
import controller.server.member.view.MenuImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberController {
    static private final String SETCLIENT = "\n"+"DATA_SET";
    static private MemberServiceImpl memberService = new MemberServiceImpl();
    static private MenuImpl menu = new MenuImpl();

    private PrintWriter pw;
    private int step;


    public void showMainMenu(){
        StringBuilder sb = menu.showBanner().append(menu.showMainMenu());
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }
    public void showJoinForm(int step){
        StringBuilder sb = menu.showJoinForm(step);
        pw.println(sb);
        pw.flush();
    }
}
