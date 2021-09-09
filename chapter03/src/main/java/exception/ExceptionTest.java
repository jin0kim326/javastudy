package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10 ;
		int b = 10 - a ;
		
		System.out.println("Some code 1 ...");
		try {
			System.out.println("Some code 2 ...");
			int result = (1 + 2 + 3) / b;
			System.out.println("Some code 3 ...");
		} catch(ArithmeticException e) {
			/* 예외 처리 하는 방법*/
			// 1. 사과 
			System.out.println("죄송합니다");
			
			// 2. 로깅
			System.out.println("Error : " + e );
			
			// 3. 정상종료
			return;
		} finally {
			System.out.println("자원 정리");
		}
	}

}
