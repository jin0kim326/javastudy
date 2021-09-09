package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		
		// public -> 접근제한없음
		g.name = "camera";
		
		// protected -> 같은 패키지에서 접근가능
		// ** 더 중요한 것 ** 자식에서도 접근이 가능함
		//g.price = 1000;
		
		// default -> 같은 패키지에서만 접근가능
		//g.countStock = 10;
		
		// private -> 같은 클래스만 접근가능, 즉 Goods2라는 다른 클래스의 변수기떄문에 접근불가
		// g.countSold = 10;
	}
}
