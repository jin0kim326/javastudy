package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		//even , odd
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		
		System.out.print("숫자를 입력하세요 : ");
		int inputNum = scanner.nextInt();
		
		
		if ((inputNum % 2) ==0 ) {
		//짝수
		for (int i=0; i<=inputNum; i++) {
			if((i%2)==0) {
				result = result + i;
			}
		}
			
		}else {
		for (int i=0; i<=inputNum; i++) {
			if((i%2)!=0) {
				result = result + i;
			}
		}

			
		}
		
		System.out.print("결과값 : " + result);
		scanner.close();
	}
}
