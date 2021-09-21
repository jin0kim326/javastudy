package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClient {
	/*
	 * 1.startClient() 2.stopClient()
	 */
	private final String IP = ChatServer.IP;
	private final int PORT = ChatServer.PORT;

	Socket socket = null;

	void startClient() {
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(IP, PORT));
			System.out.println("[클라이언트] 연결완료" + socket.getRemoteSocketAddress());
		} catch (IOException e) {
			if (!socket.isClosed()) {
				stopClient();
			}
			return;
		}
		receive();
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

	void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int readByte = in.read(buffer);
				if (readByte == -1) { throw new IOException(); }
				String message = new String(buffer, 0, readByte, "UTF-8");
				System.out.println("[클라이언트] 받기완료" + message);
			} catch (IOException e) {
				System.out.println("[클라이언트] 서버통신불가");
				stopClient();
				break;
			}
		}
	}

	void send(String message) {
		try {
			 OutputStream out = socket.getOutputStream();
			 byte[] buffer = message.getBytes();
			 out.write(buffer);
			 out.flush();
			 System.out.println("[클라이언트] 메세지 전송완료");
		} catch (IOException e) {
			System.out.println("[클라이언트] 메세지전송실패 "
								+socket.getRemoteSocketAddress());
			stopClient();
		}
	}
	public static void main(String[] args) {
		new ChatClient().startClient();
	}
}
