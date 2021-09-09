package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/*
		 버퍼 사용해서
		StringBuffer sb = new StringBuffer(str);
		String reversedStr = sb.reverse().toString();
		char[] result = reversedStr.toCharArray();
		return result;
		*/
		
		// string -> array
	    char[] cArry = str.toCharArray();
	    
	    // 리턴할 새로운 배열 만들기. (파라미터로 들어온 스트링 길이와 동일)
	    char[] rArry = new char[cArry.length];
	    
	    System.out.println(cArry.length + " / " + rArry.length);
	    
	    // 배열의길이가5면 마지막index=4 이기때문에 -1
	    int i = cArry.length-1;
	    for(char a : cArry){
	            rArry[i--] = a;
	    }
	    return rArry;
		
	}

	public static void printCharArray(char[] array){
		System.out.println( array );
	}
}