package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 7000;
	public static void main(String[] args) {
		DatagramSocket socket = null;
 
		try {
			// 1. socket 생성
			socket = new DatagramSocket(PORT);
			
			
			while (true) {
				// 2. Data 수신
				DatagramPacket rcvPacket = new DatagramPacket(new byte[1024], 1024);
				socket.receive(rcvPacket); // blocking
				
				byte[] rcvData = rcvPacket.getData();
				int length = rcvPacket.getLength();
				String message = new String(rcvData, 0, length, "utf-8");
				
				System.out.println("[server] receive:" + message);
				
				// 3. Data 송신 
				byte[] sendData = message.getBytes("utf-8");
				DatagramPacket sndPacket = 
							new DatagramPacket( sendData,
												sendData.length,
												rcvPacket.getAddress(),
												rcvPacket.getPort());
				
				socket.send(sndPacket);
			}
		} catch (SocketException e) {
			System.out.println("error : " + e);
		} catch (IOException e ) {
			System.out.println("error : " + e);
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
