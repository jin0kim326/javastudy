package prob1;

public class Sort {

	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };

		int count = array.length;

		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		// 버블 정렬을 실행하는 횟수는 버퍼사이즈-1 
		// 한번 실행하면 최소값이 제일 오른쪽으로 오게됨, => 두번째 for문에서는 -j를 해줌
		for (int j = 0; j < count-1; j++) {
			for (int i = 0; i < count - j - 1; i++) {
				int current = array[i];
				int after = array[i + 1];

				if (current < after) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
				
			}
			System.out.print("\n"+j+"회 정렬 => ");
			for (int i = 0; i < count; i++) {
				System.out.print(array[i] + " ");
			}

		}

		// 결과 출력
		System.out.println("\nAfter Sort.");
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}