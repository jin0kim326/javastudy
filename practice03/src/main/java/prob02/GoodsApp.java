package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		String inputName = null;
		int inputPrice = 0;
		int inputStock =0;
		
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		System.out.print("재고 입력(재고,가격, 수량) >>>");
		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			inputName = scanner.next();
			inputPrice = scanner.nextInt();
			inputStock = scanner.nextInt();
			
			goods[i] = new Goods(inputName, inputPrice, inputStock);
		}
		// 상품 출력
		for(int i=0; i<COUNT_GOODS; i++) {
			goods[i].print();
		}
		
		// 자원정리
		scanner.close();
	}	
}

