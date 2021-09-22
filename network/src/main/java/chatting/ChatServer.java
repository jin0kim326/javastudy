package chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ChatServer {
	/*
	 * 1.void startServer() : 서버시작 
	 * 2.void stopServer() : 서버종료 
	 * 3.Client객체 : 서버와 연결된 클라이언트를 관리하기 위해서 
	 * 				 => 클라이언트별로 고유한 데이터 저장, Client인스턴스 생성하여 관리
	 * 				 => receive() 와 send() 메소드
	 */
	
	protected static final String IP = "0.0.0.0";
	protected static final int PORT = 5002;

	public static List<Client> connections = new Vector<Client>();
	public static ServerSocket serverSocket;

	public static void main(String[] args) {
		startServer();
	}

	public static void startServer() {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP ,PORT));
			while(true) {
				System.out.println("=== 연 결 대 기 중 ===");
				Socket socket = serverSocket.accept();
				System.out.println("[서버] 연결완료 : " + socket.getRemoteSocketAddress());
				Client client = new Client(socket);
				connections.add(client);
				new ChatServerThread(socket, client).start();
			}
		
		} catch (IOException e) {
			if (!serverSocket.isClosed()) { stopServer(); }
		}
	}

	public static void stopServer() {
		try {
			// 1. 연결된 클라이언트 모두 제거 및 소켓닫기 
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// 2. 서버 소켓 닫기
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Client {
		Socket socket;
		public Client (Socket socket) {
			this.socket = socket;
		}
		void receive() {
		}
	
		void send(String message) {
		}
	}
}
