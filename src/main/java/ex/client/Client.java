package ex.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static int PORT = 9010;
    final static String IP = "127.0.0.1";
    private static StringBuilder sb;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket(IP,PORT);
        OutputStream out = clientSocket.getOutputStream();
        OutputStreamWriter outW = new OutputStreamWriter(out);
        PrintWriter pw = new PrintWriter(outW);

        InputStream in = clientSocket.getInputStream();
        InputStreamReader inR = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(inR);

        while (true) {
            String dataSend;
            dataSend = br.readLine();
            if (dataSend.equals("EXIT")){
                break;
            }
            if (dataSend.equals("DATA_SET")){
                System.out.println("데이터 준비");
                String sendData = sc.nextLine();
                System.out.println(sendData);
                pw.println(sendData);
                pw.flush();
            }
            System.out.println(dataSend);
        }
    }

}
