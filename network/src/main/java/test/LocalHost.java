package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// Internet Address의 약자-> 즉 IP주소
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			inetAddress.getAddress();
			
			byte[] addresses = inetAddress.getAddress();
			for (byte address : addresses) {
//				System.out.print(((int)address)+".");
			System.out.print(address & 0x000000ff);
			System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
				
	}

}

/*
 * InetAddress => IP객체 ooo.ooo.ooo.ooo 
 * InetSoketAddress => IP adress + port : 통신할때 사용 
 * */
