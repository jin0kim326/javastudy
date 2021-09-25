package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientThread extends Thread{
	Socket socket = null;
	Scanner scanner = null;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while(true) {
				String message = br.readLine();
				
				// 읽어온 데이터가 null이면 접속종료 (2가지 경우) 
				//1. 클라이언트가 quit를 보내면 서버측에서 소켓을 닫기 때문에 null을 수신 
				//2. 서버가 서버를 종료하면 null 수신 
				if(message == null) {
					throw new IOException();
				}
				
				System.out.println(message);
			}
		} catch (IOException e) {
			try {
				System.out.println("[클라이언트]서버 통신 불가");
				if (socket != null && !socket.isClosed() ) {
					socket.close();
				}
				System.exit(1);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
