package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int max=100, min=0;
		int cardNumber; //정답
		int inputNum; 	//사용자의 입력값
		
		while( true ) {
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			
			System.out.println("<< 게임시작 >>");
			System.out.println("수를 결정했습니다. 맞추어 보세요");
			System.out.println(min+"~"+max);
			
			int playCount = 1;
			
				System.out.println(playCount +"번째도전 (맞출 수 입력하세요) >> ");
				inputNum = scanner.nextInt();
				
			
				

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}
	}