package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}

			System.out.println("===== 파일 정보 =====");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));

			System.out.println("===== 전화번호 =====");
			// 기반스트림 만들
			FileInputStream fis = new FileInputStream(file);
			// 보조스트림 1 만들기
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			// 보조스트림 2 만들기
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {				
				StringTokenizer st = new StringTokenizer(line, "\t " );
				int index = 0;
				
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index ==0 ) { //이름 
						System.out.print(token+":");
					} else if(index ==1 ) { //전번 1
						System.out.print(token+"-");
					} else if(index ==2 ) { //전번 2 
						System.out.print(token+"-");
					}else {
						System.out.print(token);
					}
					index++;
				}
				System.out.println("");
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println("Error : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
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
