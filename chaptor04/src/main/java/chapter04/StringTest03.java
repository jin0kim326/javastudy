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
		String s3 = "";
		for (int i=0; i < 100; i++) {
			//s3 = s3 + i;			
			//s3 = new StringBuffer(s3).append(i).toString();
			// 매 루프마다 new로 string객체를 만들기 때문에 매우느
		}
		System.out.println(s3);
		
		StringBuffer sb2 = new StringBuffer("");
		for (int i=0; i < 1000000; i++) {
			sb2.append(i);
		}
		String s4 = sb2.toString();
//		System.out.println(s4.length());
	}
}
