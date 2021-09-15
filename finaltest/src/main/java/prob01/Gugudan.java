package prob01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Gugudan {

	static int resultNumber = 0;

	public static void main(String[] args) {
		int l = randomize(2, 5);
		int r = randomize(2, 5);

		resultNumber = l * r;

		int[] answerNumbers = randomizeAnswers();
		int loc = randomize(0, 8);
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");

		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}
	
	private static int randomizeAnswer(int lNum, int rNum) {
		int randomAnswer = randomize(lNum,rNum) * randomize(lNum,rNum);
		return randomAnswer;
	}

	private static int[] randomizeAnswers() {
		/* 코드 작성(수정 가능) */
		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		
		Set<Integer> randomAnswers = new HashSet<>();
		
		
		// 중복아닌 구구단 정답9개 만들기 
		while (randomAnswers.size() < COUNT_ANSWER_NUMBER) {
			int randomAnswer = randomizeAnswer(2,5);
				// 9개의 랜덤값중 정답이 아닌경우만 add함
				if (randomAnswer != resultNumber) {
					randomAnswers.add(randomAnswer);
				}
		}
		
		// 만든 정답들 배열에 넣어주기 
		Iterator iter = randomAnswers.iterator();
		for (int i=0; i<randomAnswers.size(); i++) {	
			boardNumbers[i] = (int)iter.next();
		}
		return boardNumbers;
		
	}
	
}

/*
 * 구구단의 식을 랜덤하게 9개출력 ( 중복x 
 * */
