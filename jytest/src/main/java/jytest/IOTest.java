package jytest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	
		public static void main(String[] args) {
			InputStream is = null ;
			OutputStream os = null ;
			
			
			
			
			try {
				is = new FileInputStream("test.txt");
				os = new FileOutputStream("test.txt");
				
				byte[] data = "가나".getBytes();
				
				
				for (int i=0; i<data.length; i++) {
					os.write(data[1]);
				}
				
				
				
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
}