package controller.server.mainmenu.controller;

import controller.server.mainmenu.view.MenuImpl;
import controller.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMenuController {
    static private final String SETCLIENT = "\n" + "DATA_SET";
    static private MenuImpl menu = new MenuImpl();

    private PrintWriter pw;
    private BufferedReader br;

    // TODO: 2022-04-25 show*도 따로 빼줄것!

    //    view 만 구현해준다.
    public void showMainMenu() {
        StringBuilder sb = menu.showBanner().append(menu.showMainMenu());
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }
    public void showReserveMenu(Member member){
        StringBuilder sb = menu.showBanner().append(menu.showReserveMenu(member));
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }
    public void showReserveMenuIn() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean exit = false;
        String line;
        while (!exit){
            sb = menu.showBanner().append(menu.showReserveMenuIN());
            sb.append(SETCLIENT);
            pw.println(sb);
            pw.flush();

//            TODO 내부 이동작동 붙혀주기
            line = br.readLine();

            if (line.equals("3")){
                exit = true;
            }
        }
    }
    public void showHouseMenu() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean exit = false;
        String line;
        while (!exit){
            sb = menu.showBanner().append(menu.showHouseMenu());
            sb.append(SETCLIENT);
            pw.println(sb);
            pw.flush();

//            TODO 내부 이동작동 붙혀주기
            line = br.readLine();

            if (line.equals("3")){
                exit = true;
            }
        }
    }
}