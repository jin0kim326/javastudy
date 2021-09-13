package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "Hello " + "World" + "Java" + 1.8;
		String s2 = new StringBuffer("Hello ")
						.append("World")
						.append("Java")
						.append(1.8)
						.toString();
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		/*
		String s3 = "";
		for (int i=0; i < 100; i++) {
			//s3 = s3 + i;			
			//s3 = new StringBuffer(s3).append(i).toString();
			// 매 루프마다 new로 string객체를 만들기 때문에 매우느리다.
		}
		System.out.println(s3);
		
		StringBuffer sb2 = new StringBuffer("");
		for (int i=0; i < 100; i++) {
			sb2.append(i);
		}
		String s4 = sb2.toString();
		System.out.println(s4.length());
		*/
		
		/*  String Methods  */
		String str = "aBcABCabcAbc";
		System.out.println(str.length());
		System.out.println(str.charAt(2));
		System.out.println(str.indexOf("abc"));
		System.out.println(str.indexOf("abc",7));
		System.out.println(str.substring(3));
		System.out.println(str.substring(3,5));
		
		
		String str2 = "    ab    cd     ";
		String str3 = "efg,hi,klm,nop,qrs" ;
		
		
	}
}
