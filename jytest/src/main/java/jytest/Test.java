package jytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	protected static final String IP = "127.0.0.1";
	protected static final int PORT = 2000;
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket;	
	
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, PORT));
			while (true) {
				System.out.println("[연결대기]");
				Socket socket = serverSocket.accept();
				System.out.println("[연결완료]" + socket.getRemoteSocketAddress());
			}

		} catch (IOException e) {

		} finally {

		}
	}
}