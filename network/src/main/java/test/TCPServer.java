package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			 // 1. 서버소켓 생성 
			 serverSocket = new ServerSocket();
			 
			 //2. 바인딩(binding) 
			 //   Socket의 InetSocketAddress(IPAdress + port)
			 //  IPAdress : 0.0.0.0 (모든 IP로 부터의 연결허용)
			 serverSocket.bind(new InetSocketAddress("0.0.0.0", 2613));
			 
			 //3. accept
			 //	  클라이언트로 부터 연결 요청을 기다림.
			 Socket socket = serverSocket.accept();
			 InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			 String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			 int remoteHostPort = inetRemoteSocketAddress.getPort();
			 System.out.println("[server] Connected by client[" + remoteHostAddress + ":" + remoteHostPort +  "]");
			 
			 
			 System.out.println("accepted...");
		} catch (IOException e) {
			System.out.println("[Server] Error : "+e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
