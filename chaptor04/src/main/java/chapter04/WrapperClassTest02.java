package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
			String s1 = "123456";
			
			
			int i = Integer.parseInt(s1);	// string->int
			
			
			String s2 = String.valueOf(i);  // int -> string
			
			String s3 = "" + i ;			// int -> stirng (좋지는않음)
			
			System.out.println(s1 + ":" + s2 + ":" + s3);
			
			char c = 'A';
			int a = Character.getNumericValue('f'); 
			System.out.println(a);
			
			
			//2진수 
			String s4 = Integer.toBinaryString(15);
			System.out.println(s4);
			
			//16진수
			String s5 = Integer.toHexString(15);
			System.out.println(s5);
			/*
			 * Integer.parInt(str) :  String --->  int  형변환
			 * String.valueOf(int) :  int    --->  String  
			 *   
			 *   
			 *   
			 *   
			
			 * */
			
	}

}
