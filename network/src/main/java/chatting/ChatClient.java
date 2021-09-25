package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/*
 * 1.startClient() 
 * 2.stopClient()
 */

public class ChatClient {
	private static final String SERVER_IP = ChatServer.IP;
	private static final int SERVER_PORT = ChatServer.PORT;

	public static void startClient() {
		Socket socket = null;
		Scanner scanner = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		String PROTOCOL_MESSAGE = "message:";
		String PROTOCOL_QUIT = "quit:";
		String PROTOCOL_JOIN = "join:";

		String nickName;
		scanner = new Scanner(System.in);

		// 클라이언트의 닉네임 설정
		while (true) {
			System.out.println("대화방에 오신걸 환영합니다.");
			System.out.println("종료하시려면 quit을 입력하세요.");
			System.out.print("닉네임입력 (한글자이상) >> ");
			nickName = scanner.nextLine();

			// 닉네임이 null이면 다시 입력 받음 
			if (nickName.isEmpty()) {
				System.out.println("닉네임을 한글자 이상 입력하세요!!");
				continue;
			}

			// 닉네임 한글자이상이면 while문 빠져나감
			break;
		}

		try {
			socket = new Socket();				// 소켓생성 
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); //서버에 연결요청 

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			pw.println(PROTOCOL_JOIN + nickName); //입렫받은 닉네임으로 연결 

			// 쓰레드 시작 (클라이언트가 지속적으로 수신할 수 있도록 하는 쓰레드)
			ChatClientThread chatClientReceiveThread = new ChatClientThread(socket);
			chatClientReceiveThread.start();

			// 사용자에게 입력 받기를 계속대기
			String inputText = null;
			while (true) {
				inputText = scanner.nextLine();
				
				//사용자가 아무것도 입력하지않으면 다시 입력받음 
				if (inputText == null || "".equals(inputText)) {
					continue;
				}

				// quit를 입력하면 접속종료를 요청하고, 입력을 멈춤 
				if ("quit".equals(inputText)) {
					pw.println(PROTOCOL_QUIT + nickName);
					break;
				}
				
				// 메세지 전송 요청 
				pw.println(PROTOCOL_MESSAGE + inputText);
			}
		} catch (IOException e) {
			System.out.println("[클라이언트]서버통신불가");
		}
	}

	public static void main(String[] args) {
		startClient();
	}
}
