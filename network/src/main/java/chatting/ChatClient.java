package chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	/*
	 * 1.startClient() 2.stopClient()
	 */
	private final String IP = ChatServer.IP;
	private final int PORT = ChatServer.PORT;

	Socket socket = null;

	void startClient() {
	}

	void stopClient() {
	}

	public static void main(String[] args) {
		new ChatClient().startClient();
	}
}
