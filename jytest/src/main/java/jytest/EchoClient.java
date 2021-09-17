package jytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = ServerTest.IP;
	private static final int SERVER_PORT = ServerTest.PORT;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			scanner = new Scanner(System.in);
			
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			printLog("서버와 연결되었습니다.");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); 
			
			while (true) {
			System.out.print("E C H O 서버에 외쳐보세요 (입력)>>");
			String line = scanner.nextLine();
			pw.println(line);
			
			String data = br.readLine();
			if(data == null) {
				printLog("서버에 의해 종료되었어요 ");
				break;
			}
				printLog("서버로부터 온 메세지 : " + data);
			}
		} catch (SocketException e) {
			printLog("서버에 의해 강제종료되었어요.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
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
	private static void printLog(String log) {
		System.out.println("[JYecho Client] " + log);
	}
		
}
