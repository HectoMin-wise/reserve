package controller.server.mainmenu.controller;

import controller.server.mainmenu.view.MenuImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMenuController {
    static private final String SETCLIENT = "\n" + "DATA_SET";
    static private MenuImpl menu = new MenuImpl();

    private PrintWriter pw;

    // TODO: 2022-04-25 show*도 따로 빼줄것!

    //    view 만 구현해준다.
    public void showMainMenu() {
        StringBuilder sb = menu.showBanner().append(menu.showMainMenu());
        sb.append(SETCLIENT);
        pw.println(sb);
        pw.flush();
    }
}