package prob03;


public class Prob03 {
	public void printCharArray(char initchars[]) {
		String str = String.valueOf(initchars);
	    System.out.println(str);
	}
	
	public void replaceSpace(char chars[]) {
		String willChangeString = String.valueOf(chars);
		String changedString = willChangeString.replace(' ', ',');
		char c[] = changedString.toCharArray();	
	}
	
	
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };	
		Prob03 prob = new Prob03();
		prob.printCharArray(c);
		// 공백 문자 바꾸기
		prob.replaceSpace(c);
		// 수정된 배열 원소 출력
		prob.printCharArray(c);
	}
}

/*
 replaceSpace에서 변경한 값을 어떻게 char c[]에 적용해야할지 모르겠음...
 */
 