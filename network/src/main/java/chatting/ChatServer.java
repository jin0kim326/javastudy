package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	
	protected static final String IP = "localhost";
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
				Socket socket = serverSocket.accept();
				System.out.println("[서버] 연결완료 : " + socket.getRemoteSocketAddress());
				
				new ChatServerThread(socket).start();
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
			connections.add(Client.this);
			this.socket = socket;
			receive();
		}
		void receive() {
			System.out.println("receive() 호");
			try {
				while(true) {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					String message = br.readLine();
					if (message == null || message.equals("quit")) {
						throw new IOException();
					}
					
					System.out.println("concs" + connections.size());
					System.out.println("msg" + message);
					for (Client client : connections) {
						client.send(message);
					}
				}
			}  catch (IOException e) {
				try { 
					ChatServer.connections.remove(Client.this);	//연결된 클라이언트목록에서 해당 클라이언트 제거
					System.out.println("[서버] 클라이언트와 통신불가" + socket.getRemoteSocketAddress());
					socket.close();
				} catch(IOException e2) {
					e.printStackTrace();
				}
			}
		}
	
		void send(String message) {
			try {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				pw.println(message);
			} catch (IOException e) {
				try { 
					ChatServer.connections.remove(Client.this);	//연결된 클라이언트목록에서 해당 클라이언트 제거
					System.out.println("[서버] 클라이언트와 통신불가" + socket.getRemoteSocketAddress());
					socket.close();
				} catch(IOException e2) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
