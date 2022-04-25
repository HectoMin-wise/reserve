package controller.server;

import controller.server.member.controller.MemberController;
import controller.server.member.controller.MemberJoinController;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;

class ServerAction extends Thread {
    public final static String DB = "User.txt";
    private Socket socket;
    private InetAddress inetAddr;

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

            ActionController actionController;
            MemberController memberController = new MemberController(pw,br,0);

            while (true) {
                memberController.showMainMenu();
                // 클라이언트가 보내온 전체 패킷을 수신
                String line = br.readLine();
                if (false) {
                    System.out.println("Disconnect Client");
                    break;
                }
                System.out.println("Received Data : " + line +" "+line.equals("1"));

                switch (line) {
                    case "1":
                        memberController.joinMember(br, line);
                        System.out.println("누군가의 가입!");
                        break;
                    case "2":
                        SendMemberList(pw, line);
                        break;
                    case "3":
                        DeleteMember(pwF, pw, line);
                        break;
                    case "4":
                        LoginMemberForUpdate(pwF, pw, line);
                        break;
                    case "5":
                        UpdateMemberPw(pwF, pw, line);
                    case "EXIT":
                        break;
                }
            }
        } catch (Exception e) {

        }
    }

    private void UpdateMemberPw(PrintWriter pwF, PrintWriter pw, String line) throws InterruptedException, SQLException {
        ActionController actionController;
        actionController = new ActionController(line, pwF, pw, DB);
        UpdateUser updateUser = new UpdateUser(actionController);
        Thread s5 = new Thread(updateUser);
        s5.start();
        s5.join();
    }

    private void LoginMemberForUpdate(PrintWriter pwF, PrintWriter pw, String line) throws InterruptedException, SQLException {
        ActionController actionController;
        actionController = new ActionController(line, pwF, pw, DB);
        UpdateSet updateSet = new UpdateSet(actionController);
        Thread s4 = new Thread(updateSet);
        s4.start();
        s4.join();
    }

    private void DeleteMember(PrintWriter pwF, PrintWriter pw, String line) throws InterruptedException, SQLException {
        ActionController actionController;
        if (line.equals("DELETE")) {// 삭제할 값이 안오면 미작동.!
            pw.println("DELETE");
            pw.flush();
            return;
        }
        actionController = new ActionController(line.split(" ")[1], pwF, pw, DB);
        DeleteUser deleteUser = new DeleteUser(actionController);
        Thread s3 = new Thread(deleteUser);
        s3.start();
        s3.join();
    }

    private void SendMemberList(PrintWriter pw, String line) throws InterruptedException, SQLException {
        ActionController actionController;
        actionController = new ActionController(Integer.parseInt(line.split(" ")[1]), 20, DB, pw);
        ListSend listSend = new ListSend(actionController);
        Thread s2 = new Thread(listSend);
        s2.start();
        s2.join();
    }
}
