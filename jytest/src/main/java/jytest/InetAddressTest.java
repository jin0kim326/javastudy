package jytest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		// 로컬 ip주소와 네이버 ip주소 출력하기
		try {
			InetAddress local =  InetAddress.getLocalHost();
			System.out.println(local.getHostAddress());
			
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
			for (InetAddress ip : naver) {
				System.out.println(ip);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		

	}

}
