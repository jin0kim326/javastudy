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
				if(message == null) {
					throw new IOException();
				}
				System.out.println(message);
			}
		} catch (IOException e) {
			System.out.println("[클라이언트]서버통신불가");
			System.exit(1);
		}
	}
}
