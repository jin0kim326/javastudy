package chatting;

import java.io.IOException;
import java.net.Socket;

import chatting.ChatServer.Client;

public class ChatServerThread extends Thread {
	Socket socket = null;
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
//		try {
			Client client = new Client(socket);
			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}



/*
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
*/