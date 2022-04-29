package controller.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Server {
	private static Logger log = LoggerFactory.getLogger(Server.class);
	private final static int PORT = 9010;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		while (true){
			Socket conSocket = serverSocket.accept();
			InetAddress inetAddr = conSocket.getInetAddress();
			System.out.println("Connect "+inetAddr);
			ServerAction server = new ServerAction(conSocket,inetAddr);
			server.start();
		}
	}
}

