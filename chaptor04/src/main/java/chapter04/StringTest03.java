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
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		/*  String Methods  */
		String str = "aBcABCabcAbc";
		System.out.println(str.length());
		System.out.println(str.charAt(2));
		System.out.println(str.indexOf("abc"));
		System.out.println(str.indexOf("abc",7));
		System.out.println(str.substring(3));
		System.out.println(str.substring(3,5));
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		
		String str2 = "    ab    cd     ";
		String str3 = "efg,hi,klm,nop,qrs" ;
		
		String concatStr = str2.concat(str3);
		System.out.println(concatStr);
		
		
		System.out.println("---" + str2.trim() + "---");
		System.out.println("---" + str2.replaceAll(" ", "") + "---");
		
		String[] tokens = str3.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		
		String[] tokens2 = str3.split(" ");
		for (String s : tokens2) {
			System.out.println(s);
		}
		/*
		 1. length() : 스트링(객체)의 길이
		 2. charAt(int index) : index에 해당하는 문자 출력 .
		 3. indexOf(String findStr) : 찾고자 하는 스트링의 첫인덱스값
		 4. indexOf(String findStr, int index) : 찾고자 하는 스트링의 첫인덱스값
		 5. subString(int startIndex) : index값 이후의 스트링을 반환
		 6. sbuString(int startIndex, int lastIndex) : 시작인덱스 ~ (끝인덱스 - 1) 까지 반환
		 
		 7. str1.concat(Str2) : str1 + str2 
		 8. str1.trim() : 양 끝의 공백삭제
		 9. str.replaceAll(바뀔문자, 뭐로바꿀지) : 해당하는 문자를 원하는 문자로 바꿈
		 10. strArray.split(divideChar) : 원하는 문자로 나눔 
		     + DividChar 가 문자열내에 없으면 나누지않음 
		 * */
		
	}
}
