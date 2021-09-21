package chat;

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
		try {
			Scanner scanner = new Scanner(System.in);

			socket = new Socket();
			socket.connect(new InetSocketAddress(IP, PORT));
			System.out.println("[클라이언트] 연결완료" + socket.getRemoteSocketAddress());
			new ChatClientThread(socket).start();
			
		} catch (IOException e) {
			if (!socket.isClosed()) {
				stopClient();
			}
			return;
		}
//		receive();
	}

	void stopClient() {
		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatClient().startClient();
	}
}
