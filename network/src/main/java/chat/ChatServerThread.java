package chat;

import java.net.Socket;

public class ChatServerThread extends Thread {
	Socket socket = null;
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
	}
}
