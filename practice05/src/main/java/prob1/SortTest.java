package prob1;

public class SortTest {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		boolean check = true;	//버블정렬을 더 실행할 것인지 판단하는 변수
		int temp = 0;	//변수를 바꾸기 위해 생성한 temp변수
		
		
		while(check) {
			//처음 반복 check는 false 설정
			check=false;
			//버블정렬 교환 과정
			for(int i=0; i<array.length-1; i++) {
				if(array[i] < array[i+1]) {
					temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					
					//한번이라도 정렬과정이 실행되었으면 check=true;
					check = true;
				}
			}
		}
		
		
		/*
		for(int i=0; i<array.length-1; i++) {
			if(array[i] < array[i+1]) {
				temp = array[i+1];
				array[i+1] = array[i];
				array[i] = temp;
				
				//한번이라도 정렬과정이 실행되었으면 check=true;
				check = true;
			} 
		}
		*/
		
		// 결과 출력
		System.out.println();
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}