package chat;

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
		scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("입력 >>");
			String message = scanner.nextLine();
			System.out.println("입력메세지 :"+message);
			send(message);
			receive();
		}
		
	}

	void receive() {
		while(true) {
			try {
				System.out.println("[클라이언트 받을준비중");
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int readByte = in.read(buffer);
				if (readByte == -1) { throw new IOException(); }
				String message = new String(buffer, 0, readByte, "UTF-8");
				System.out.println("[클라이언트] 받기완료" + message);
			} catch (IOException e) {
				System.out.println("[클라이언트] 서버통신불가");
				new ChatClient().stopClient();
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
			new ChatClient().stopClient();
		}
	}
	
	
}
