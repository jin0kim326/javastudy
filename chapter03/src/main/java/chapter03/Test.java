package chapter03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {	
	public static void main(String[] args) {
		InputStream is = null ;
		OutputStream os = null ;
		
		try {
			is = new FileInputStream("hello.txt");
			os = new FileOutputStream("hello_copy.txt");
			
			int readData = -1;
//			
			while ( (readData = is.read()) != -1) {
				 os.write(readData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}