package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		//even , odd
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		
		System.out.print("숫자를 입력하세요 : ");
		int inputNum = scanner.nextInt();
		
		//짝수인 경우
		if ((inputNum % 2) ==0 ) {
		for (int i=0; i<=inputNum; i++) {
			if((i%2)==0) {
				result = result + i;
			}
		}
		//홀수인 경우
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
