package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.naver.com";
		
		 
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);		// => 이름으로 모든 ip주소를 가져오겠다
			
			for (InetAddress inetAddress : inetAddresses) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
	}

}
