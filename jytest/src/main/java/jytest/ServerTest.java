package jytest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	protected static final String IP = "127.0.0.1";
	protected static final int PORT = 2000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket =null;
		OutputStream os = null;
		InputStream is = null;
		String msg = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, PORT));
			
			while(true) {
				System.out.println("연결대기중...");
				socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("연결됨 : " +isa.getHostName() + ":" + isa.getAddress());
				
				//데이터받기 
				is = socket.getInputStream();
				byte[] bytes = new byte[100];
				int readBytes = is.read(bytes);
				String rcvData = new String(bytes, 0, readBytes, "utf-8");
				System.out.println("[sever] 데이터 수신 : " + rcvData);
				
				// 데이터 보내기
				
				os = socket.getOutputStream();
				msg = "Hello Client";
				byte[] sendData = msg.getBytes("utf-8");
				os.write(sendData);
				System.out.println("[server] 데이터 전송 : " + sendData);
				
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( serverSocket != null && !serverSocket.isClosed() ) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
