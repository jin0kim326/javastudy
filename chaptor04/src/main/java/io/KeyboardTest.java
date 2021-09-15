package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


		//1. 기반스트림 (표준입력, stdin, System.in)
		//2. 보조스트림1 ( byte|byte|byte => char) utp8일때 가 
		//3. 보조스트림2 ( char1|char2|char3|char4|\n -> "char1char2char3char4" )
public class KeyboardTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 보조스트림 1 만들기
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			
			// 보조스트림 2 만들기
			br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error : "+ e);
		} catch (IOException e) {
			System.out.println("Error : "+ e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
