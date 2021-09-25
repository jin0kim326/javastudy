package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private List<Writer> connections;		// 입력버퍼를 리스트에 저장
	String nickName;						// 클라이언트로 부터 입력된 닉네임 저장
	
	public ChatServerThread(Socket socket, List<Writer> connections) {
		this.socket = socket;
		this.connections = connections;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while(true) {
				String data = br.readLine();
				
				// 읽어온 데이터가 null 이면 접속종료 
				if (data == null) {
					quitUser(pw);
				}
				
				// 읽어온 데이터를 매개변수로 받는 프로토콜 호출 
				protocol(pw, data);
			}
		} catch (Exception e) {
		} 
	}
	
	/*
	 * 서버로 부터 요청 될 수 있는 작업목록
	 * 1. JOIN : 클라이언트의 최초 접속 요청
	 * 2. MESSAGE : 채팅창에 입력하여 메세지 전송요청 
	 * 3. QUIT : 접속 종료 요청 
	 * */
	private void protocol(PrintWriter pw, String entryData) {
		// 클라이언트로 부터 넘어온 데이터를 : 를 기준으로 나눈다.
		// ex) join:client1 이면  data[0]=join, data[1]=client1 이된다.
		// 이렇게 클라이언트로부터 받은 데이터를 검사하는 프로토콜 
		String[] data = entryData.split(":"); 
		String protocol = data[0];
		String realData = data[1];
		
		if ("join".equals(protocol)) {
			joinUser(pw, realData);
		}
		if ("quit".equals(protocol)) {
			quitUser(pw);
		} 
		if ("message".equals(protocol)) {
			sendToAll(ChatServer.getCurrentTime(new Date(), "(HH:mm)") 
					  + "[" + nickName +"]:"
					  + realData);
		} 

	}

	// 1. JOIN 
	// nickName을 스레드의 local변수로 저장
	// connections (list)에 클라이언트 입력버퍼를 저장
	void joinUser (Writer pw, String clientName) {
		this.nickName = clientName;
		connections.add(pw);
		recordServerLog("[서버] 클라이언트 접속");
		sendToAll("< " + clientName + "님이 입장했습니다 >");
	}
	
	// 2. MESSAGE
	// 클라이언트로 받은 메세지를 접속된 모든 클라이언트에 전송
	void sendToAll(String message) {
		for (Writer writer : connections) {
			PrintWriter pw = (PrintWriter) writer;
			pw.println(message);
		}
		recordServerLog("[서버]데이터 전송완료");
	}
	
	// 3. QUIT
	// 클라이언트의 접속 종료 
	// connections (List)에서 버퍼를 제거하고, 접속소켓을 close
	void quitUser(Writer pw) {
		sendToAll("< "+ nickName+" 님이 퇴장했습니다. >");
		try {
			connections.remove(pw);
			if( socket != null && !socket.isClosed()) {
				socket.close();
			}
			recordServerLog("[서버] 클라이언트 접속 종료");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 서버에서 일어나는 모든일을 console에 로그로 기록 
	void recordServerLog(String log) {
		System.out.println(log 
		+ " | 기록시각 :"
	    + ChatServer.getCurrentTime(new Date(), "[HH:mm:ss]")
	    + " | 통신중인 클라이언트수 :"
	    + connections.size() +"개");
	}
}

	
