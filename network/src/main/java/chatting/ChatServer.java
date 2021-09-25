package chatting;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/*
 * 1.void startServer() : 서버시작 
 * 2.void stopServer() : 서버종료 
 * 3.Client객체 : 서버와 연결된 클라이언트를 관리하기 위해서 
 * 				 => 클라이언트별로 고유한 데이터 저장, Client인스턴스 생성하여 관리
 */
public class ChatServer {
	protected static final String IP = "localhost";
	protected static final int PORT = 5002;
	protected static final String SERVER_DATE_FORMAT = "[yyyy-MM-dd HH:mm:ss]";

	
	public static void main(String[] args) {
		ServerSocket serverSocket= null;
		List<Writer> connections = new Vector<Writer>();
		
		try {
			
			serverSocket = new ServerSocket();					// 서버 소켓 생성 
			serverSocket.bind(new InetSocketAddress(IP ,PORT)); // 바인딩 
			
			// 클라이언트와 연결대기 (지속적으로 클라이언트연결을 대기함 
			while(true) {
				// 받아들인 소켓을 socket변수에 할당, 즉 accept되면 연결되었다는 뜻
				Socket socket = serverSocket.accept();
				System.out.println("[서버]연결완료 : " + socket.getRemoteSocketAddress()
													+ " | 연결시각 :" 
													+ getCurrentTime(new Date(),SERVER_DATE_FORMAT));
				// 받아들인 소켓을 매개변수로 받는 쓰레드를 실행 
				new ChatServerThread(socket, connections).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String getCurrentTime(Date time, String format) {
		SimpleDateFormat format1 = new SimpleDateFormat (format);
		String curruntTime = format1.format(time);
		return curruntTime;
	}
}

