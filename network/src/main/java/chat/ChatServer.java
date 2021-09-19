package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import jytest.ChatServer.ServerReceiver;

public class ChatServer {
	/*
	 * 1.void startServer() : 서버시작 2.void stopServer() : 서버종료
	 * 
	 */
	protected final String IP = "0.0,0.0";
	protected final int PORT = 3001;
	
	List<Client> connections = new Vector<Client>();
	
	public static void main(String[] args) {
		new ChatServer().startServer();
	}

	void startServer() {
		// 서버소켓 연결
		// 리스트 관리 ( 연결된 클라이언트 객체들)
		ServerSocket serverSocket = null;
		System.out.println("[서버시작]");
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, PORT));
			System.out.println("hi");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("[연결완료]" + socket.getRemoteSocketAddress());
				
				ChatServerThread chatServerThread = new ChatServerThread(socket);
			    chatServerThread.start();
			}
		} catch (IOException e) {

		} finally {

		}

	}

	void stopServer() {

	}

	class Client {

	}

	

}
