package chat;

import java.io.IOException;
import java.net.Socket;

import chat.ChatServer;
import chat.ChatServer.Client;

public class ChatServerThread extends Thread {
	Socket socket = null;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
			ChatServer.connections.add(new Client(socket));
	}
//	
}