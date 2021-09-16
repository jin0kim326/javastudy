package jytest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket =null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 1862));
			
			while(true) {
				System.out.println("연결대기중...");
				socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("연결됨 : " +isa.getHostName());
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
