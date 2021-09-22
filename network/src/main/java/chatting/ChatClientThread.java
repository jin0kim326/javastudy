package chatting;

import java.io.IOException;
import java.io.InputStream;
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
	}

	void receive() {
	}

	void send(String message) {
	}
}
