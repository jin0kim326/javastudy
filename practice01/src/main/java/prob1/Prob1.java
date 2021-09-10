package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		System.out.print("수를 입력하시오@@@ : ");
		int num = scanner.nextInt();
		
		if((num % 3) == 0) {
			System.out.println("O 3의 배수가 맞습니다 O");
		} else {
			System.out.println("X 3의 배수가 아닙니다 X");
		}
		
		scanner.close();
	}
}
