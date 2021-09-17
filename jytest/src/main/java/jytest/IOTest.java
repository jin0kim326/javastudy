package jytest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	
		public static void main(String[] args) {
			InputStream is = null ;
			OutputStream os = null ;
			
			try {
				
				
				is = new FileInputStream("test.txt");
//				os = new FileOutputStream("test.txt");
//				byte[] bytes = new byte[100];
//				int readByteCount = is.read(bytes);
//				String data = new String(bytes, 0, readByteCount, "UTF-8");
				
				int readData;
				byte[] bytes= new byte[100];
				int no = is.read(bytes);
				System.out.println(no);
//				while ((readData =is.read(bytes)) != -1) {
//					System.out.println(new String(bytes,0,readData,"utf-8"));
//				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}