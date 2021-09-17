package jytest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTest {
	private static final String SERVER_IP = ServerTest.IP;
	private static final int SERVER_PORT = ServerTest.PORT;
	
	public static void main(String[] args) {
		Socket socket = null;
//		BufferedOutputStream bos = null;
		OutputStream os = null;
		InputStream is = null;
		
		try {
			socket = new Socket();
			
			System.out.println("연결요청");
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("연결 성공");
			
			
			// 데이터 보내기
			os =socket.getOutputStream();
			String msg = "Hello SERVER~";
			byte[] sendData = msg.getBytes("utf-8");
			os.write(sendData);
			System.out.println("[Client] 데이터 전송 : " + sendData);
			
			// 데이터 받기
			is = socket.getInputStream();
			byte[] rcvData = new byte[100];
			int readByteCount = is.read(rcvData);
			String rcvMsg = new String(rcvData, 0, rcvData.length, "UTF-8");
			System.out.println("[client] 데이터 수신 : "+ rcvMsg);
			
			
			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null & !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
