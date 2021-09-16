package jytest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTest {

	public static void main(String[] args) {
		Socket socket = null;
		
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1",1862));
			
			
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
