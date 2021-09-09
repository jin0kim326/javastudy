package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);		
		goods.showInfo();
		int discountPrice = goods.calcDiscountPrice(50);
		System.out.println("할인된 가격 : " + discountPrice);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		/*
		System.out.println(goods);
		print method는 goods 의 toString을 불러온다
		출력값 chapter03.Goods@15db9742 => 패캐지명,클래스명@메모리주소를 hashing한 값 (F3)누르면 코드확인가능
		*/
		
		/*
		 goods 변수는 stack에 들어감
		 */
		
	}
}
