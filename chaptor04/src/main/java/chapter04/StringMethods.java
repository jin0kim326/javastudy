package chapter04;

public class StringMethods {
	public static void main(String[] args) {
		String str = "aBcABCabcAbc";
		System.out.println(str.length());
		System.out.println(str.charAt(2));
		System.out.println(str.indexOf("abc"));
		System.out.println(str.indexOf("abc",7));
		System.out.println(str.substring(3));
		
		String str2 = "    ab    cd     ";
		String str3 = "efg,hi,klm,nop,qrs" ;
		
	}

}
