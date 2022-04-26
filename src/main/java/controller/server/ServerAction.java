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
    public static final String DB = "User.txt";
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
            OutputStream outfile = new FileOutputStream(DB, true);
            BufferedOutputStream bFOut = new BufferedOutputStream(outfile);
            PrintWriter pwF = new PrintWriter(bFOut);

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outW = new OutputStreamWriter(out);
            PrintWriter pw = new PrintWriter(outW);

            InputStream in = socket.getInputStream();
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inR);

            MemberController memberController = new MemberController(pw,br,0);
            MainMenuController mainMenuController = new MainMenuController(pw);
            member.setId(IDKEY);

            while (true) {
                if (!member.getId().isEmpty() && !member.getId().equals(IDKEY)) {
//                    TODO 2번 째 메뉴 작업.
                    System.out.println("로그인 후 메뉴들");
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
