package jytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	protected static final String IP = "127.0.0.1";
	protected static final int PORT = 2000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, PORT));
			
			
			while(true) {
				printLog("접속대기중");
				socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				printLog( isa.getAddress().getHostAddress() +":"+ isa.getPort()+"가 접속했어요.");
				
				// IO 
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				
				while (true) {
					String rcvData = br.readLine();
					if (rcvData == null) {
						printLog("클라이언트에 의해 종료");
						break;
					}
					printLog("데이터 수신 : " + rcvData);
					pw.println(rcvData);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e ) {
				printLog("소켓 안닫힘 or 비어있지않음");
			}
		}
	}
	public static void printLog(String log) {
		System.out.println("[JYEcho Server] : " + log);
	}
}
