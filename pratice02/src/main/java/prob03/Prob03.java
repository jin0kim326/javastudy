package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
	}
	
	public static void replaceSpace(char a[]) {
		int length = a.length;
		
		for (int i=0; i < length; i++) {
			
		}
	}
	
	public static void printCharArray(char a[]) {
		System.out.println(a);
	}

}