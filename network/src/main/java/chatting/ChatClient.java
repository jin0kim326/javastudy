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
		Scanner scanner=null;
		
		try { 
			String nickName;
			scanner = new Scanner(System.in);

			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			
			//클라이언트의 닉네임 설정
			while(true) {
				System.out.println("대화방에 오신걸 환영합니다." );
				System.out.println("종료하시려면 quit을 입력하세요." );
				System.out.print("닉네임입력 (한글자이상) >> " );
			    nickName = scanner.nextLine();
			    if ( !nickName.isEmpty() ) {
			    	break;
			    }
			    
			    System.out.println("닉네임을 한글자 이상 입력하세요!!");
			}
		    pw.println(nickName);
		    
		    // 쓰레드 시작  (클라이언트가 지속적으로 수신할 수 있도록 하는 쓰레드)
		    ChatClientThread chatClientReceiveThread = new ChatClientThread(socket);
		    chatClientReceiveThread.start();
		   
		    // 사용자에게 입력 받기를 계속대기 
		    String inputText = null;
		    while( true ) {
		       inputText = scanner.nextLine();
		       
		       // quit 라고 입력하면 IOException 발생 => stopClient();
		       if( "quit".equals(inputText )) {
		    	   break;
		       }
		       // 입력받은 텍스트 전송
		    	pw.println(inputText);
		    }
 		} catch (IOException e) {
 			System.out.println("[클라이언트]서버통신불가");
 		} finally {
 			try {
 				System.out.println("[클라이언트] 연결종료");
 				if (scanner != null) {
 					scanner.close();
 				}
 				if (socket != null && !socket.isClosed()) {
 					socket.close();
 				} 
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 			
 		}
	}

	public static void main(String[] args) {
		startClient();
	}
}
