package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import echo.EchoServerReceiveThread;

public class ChatServer {
	/*
	 * 1.void startServer() : 서버시작 2.void stopServer() : 서버종료 3.Client객체 : 서버와 연결된
	 * 클라이언트를 관리하기 위해서 => 클라이언트별로 고유한 데이터 저장, Client인스턴스 생성하여 관리 => receive() 와
	 * send() 메소드
	 */
	protected static final String IP = "localhost";
	protected static final int PORT = 5001;

	public static List<Client> connections = new Vector<Client>();
	ServerSocket serverSocket;

	public static void main(String[] args) {
		new ChatServer().startServer();
	}

	void startServer() {
		Socket socket = null;
		System.out.println("[서버시작]");

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, PORT));
		} catch (IOException e) {
			e.printStackTrace();
			if (serverSocket != null && !serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		while (true) {
			try {
				socket = serverSocket.accept();
				System.out.println("[연결완료]" + socket.getRemoteSocketAddress());
//				new ChatServerThread(socket).start();

				connections.add(new Client(socket));
				System.out.println("aaaa"+ connections.size());
				
//				client.receive();

			} catch (IOException e2) {
				if (!serverSocket.isClosed()) {
					stopServer();
				}
				break;
			}
		}
	}

	void stopServer() {
		try {
			// 클라리언트 모두 접속종료 시키기
			Iterator<Client> iterator = connections.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if (serverSocket != null && serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Client {
		String name;
		Socket socket;

		public Client(Socket socket) {
			this.socket = socket;
			System.out.println("생성직"+ connections.size());
			receive();
		}

		void receive() {
			while (true) {
				try {
					InputStream in = socket.getInputStream();
					byte[] buffer = new byte[512];
					int readByte = in.read(buffer);
					if (readByte == -1) {
						throw new IOException();
					}
					System.out.println("[서버]메세지 수신성공 : "
											+ socket.getRemoteSocketAddress()
											+ ":"
											+ connections.size());

					String message = new String(buffer, 0, readByte, "UTF-8");

					for (Client client : connections) {
						client.send(message);
					}
				} catch (IOException e) {
					try {
						connections.remove(Client.this);
						socket.close();
					} catch (IOException e2) {
						e.printStackTrace();
					}

				}
			}
		}

		void send(String message) {
			try {
				OutputStream out = socket.getOutputStream();
				byte[] buffer = message.getBytes();
				out.write(buffer);
				out.flush();
			} catch (IOException e2) {
				try {
					System.out.println("[서버]메세지 전송실패 :" + socket.getRemoteSocketAddress());
					connections.remove(Client.this);
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
