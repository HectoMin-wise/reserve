package controller.server;

import controller.server.mainmenu.controller.MainMenuController;
import controller.server.member.controller.MemberController;
import controller.server.member.controller.MemberJoinController;
import controller.server.member.entity.Member;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;

class ServerAction extends Thread {
    public static final String IDKEY = "NOTLOGIN";
    private Socket socket;
    private InetAddress inetAddr;
    public static Member member = new Member();

    ServerAction(Socket socket, InetAddress inetAddr) {
        this.socket = socket;
        this.inetAddr = inetAddr;
    }

    @Override
    public void run() {
        try {

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outW = new OutputStreamWriter(out);
            PrintWriter pw = new PrintWriter(outW);

            InputStream in = socket.getInputStream();
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inR);

            MemberController memberController = new MemberController(pw,br,0);
            MainMenuController mainMenuController = new MainMenuController(pw,br);
            member.setId(IDKEY);

            while (true) {
                if (!member.getId().isEmpty() && !member.getId().equals(IDKEY)) {
//                    TODO 2번 째 메뉴 작업.
                    mainMenuController.showReserveMenu(member);
                    String line = br.readLine();
//                    TODO 내부 선택지에 따른 동작 잡아주기
                    switch (line) {
                        case "1":
                            mainMenuController.showReserveMenuIn(member);
                            break;
                        case "2":
                            mainMenuController.showHouseMenu();
                            break;
                        case "3":
                            member.setId(IDKEY);
                            break;
                        case "EXIT":
                            break;
                    }
                } else {
                    mainMenuController.showMainMenu();
                    // 클라이언트가 보내온 전체 패킷을 수신
                    String line = br.readLine();
                    if (false) {
                        System.out.println("Disconnect Client");
                        break;
                    }
                    System.out.println("Received Data : " + line);
                    switch (line) {
                        case "1":
                            memberController.joinMember(br, line);
                            System.out.println("누군가의 가입!");
                            break;
                        case "2":
                            member = memberController.loginMember(br, line);
                            break;
                        case "3":
                            break;
                        case "EXIT":
                            break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
