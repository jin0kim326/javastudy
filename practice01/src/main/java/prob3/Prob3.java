package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//hello
		System.out.print("숫자를 입력하세요 : ");
		int inputNum = scanner.nextInt();
		
		System.out.print(inputNum);
		scanner.close();
	}
}
