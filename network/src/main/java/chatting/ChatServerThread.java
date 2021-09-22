package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import chatting.ChatServer.Client;

public class ChatServerThread extends Thread {
	Socket socket = null;
	Client client = null;
	public ChatServerThread(Socket socket, Client client) {
		this.socket = socket;
		this.client = client;
	}
	@Override
	public void run() {
		
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				
				while(true) {
					String message = br.readLine();
					if (message == null || message.equals("quit")) {
						throw new IOException();
					}
					System.out.println("요청처리" +socket.getRemoteSocketAddress());
					System.out.println("클라이언트개수: " + ChatServer.connections.size());
					System.out.println("message"+message);
					for (Client client : ChatServer.connections ) {
						Socket clientSocket = client.socket;
						pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
						pw.println(message);
					}
				}
			} catch (IOException e) {
				try { 
					ChatServer.connections.remove(client);	//연결된 클라이언트목록에서 해당 클라이언트 제거
					System.out.println("[서버] 클라이언트와 통신불가" + socket.getRemoteSocketAddress());
					socket.close();
				} catch(IOException e2) {
					e.printStackTrace();
				}
			} finally {
				
			}
		
	}
	public void sendToAll(String message) {
		for (Client client : ChatServer.connections ) {
//			Socket clientSocket = client.socket;
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
//			pw.println(message);
		}
	}
	
}

////채팅 프로그램 과정
//1 >> 키보드 연결 scanner (입력을 받음)
//   System.out.print(">>");
//2 >> s = new socket(); 소켓 생성
//3 >> s.connect();
//4 >> pw.println("JOIN " +  nickname);
//5 >> br.readLine()
//6 >> new ChatClientThread(socket).start();
//7 >> whilte(true) {
//scanner.nextLine();
//} 