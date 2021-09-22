package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	/*
	 * 1.startClient() 
	 * 2.stopClient()
	 */
	private static final String SERVER_IP = ChatServer.IP;
	private static final int SERVER_PORT = ChatServer.PORT;

	static Socket socket = null;
	
	public static void startClient() {
		try { 
			Scanner scanner = new Scanner(System.in);

			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			System.out.print("닉네임>> " );
		    String nickname = scanner.nextLine();
		    pw.println(nickname);
		    
		    ChatClientThread chatClientReceiveThread = new ChatClientThread(socket);
		    chatClientReceiveThread.start();
		    
		    String inputText = null;
		    while( true ) {
//		    	System.out.print(nickname+">>");
		       inputText = scanner.nextLine();
		       if( "quit".equals(inputText ) == true ) {
		    	   stopClient();
		           break;
		       }
		    	   pw.println(inputText);
		    }
 		} catch (IOException e) {
 			stopClient();
 		}
		
	}

	public static void stopClient() {
		try {
			System.out.println("[클라이언트] 연결끊음");
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		startClient();
	}
}
