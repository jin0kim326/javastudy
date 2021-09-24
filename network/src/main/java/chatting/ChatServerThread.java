package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private List<User> connections;
	User user;
	
	public ChatServerThread(Socket socket, List<User> connections) {
		this.socket = socket;
		this.connections = connections;
	}
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String nickName = br.readLine();
			user = new User(socket, nickName);
			
			connections.add(user);
			
			alertNotice("< "+ nickName+"님이 입장했습니다. >");
			
			System.out.println("[서버] 통신중인 클라이언트 : " + connections.size() + "개");
			receive();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				alertNotice("< "+ user.nickName+" 님이 퇴장했습니다. >");
				//연결된 클라이언트목록에서 해당 클라이언트 제거 
				connections.remove(user);	
				System.out.println("[서버] 클라이언트와 통신불가" + socket.getRemoteSocketAddress()
															+ " | 클라이언트(nickName) :"
														    + user.nickName);
				//소켓 종료 
				socket.close();
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	void receive() {
		try {
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				String message = br.readLine();
				
				// 클라이언트측에서 정상적으로 종료를 요청한 경우 
				if (message == null || message.equals("quit")) {
					break;
				}
				System.out.println("[서버]처리완료 : "+socket.getRemoteSocketAddress()
												   + " | 클라이언트(nickName): "
												   + user.nickName
												   + " | 처리일시 : "
												   + ChatServer.getCurrentTime(new Date(),ChatServer.SERVER_DATE_FORMAT));
				// 클라이언트로 받은 메세지를 연결된 모든클라이언트에게 전송함 
				sendToAll(message);
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	// 연결된 모든 클라이언트에 메세지를 전송하는 메소드 
	void sendToAll(String message) {
		String clientName = user.nickName;	// 보내는클라이언트의 닉네임을 저장 
		// connections에 저장된 모든 클라이언트 돌면서 send() 호출
		for (User user : connections) {
			send(ChatServer.getCurrentTime(new Date(), "(HH:mm)")
				+ " [" +clientName+"] "
				+ message
					, user.socket);
		}
	}
	
	void send(String message, Socket socket) {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	// 서버의 공지사항을 클라이언트에 전송하는 메소드
	void alertNotice(String serverMsg) {
		for (User user : connections) {
			send(serverMsg, user.socket);
		}
	}
}

	
