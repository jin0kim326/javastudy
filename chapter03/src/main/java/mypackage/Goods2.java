package mypackage;

public class Goods2 {
	public String name;		// 모든 접근 가능 (접근제한X)
	protected int price; 	// 같은 패키지 + *자식 접근이 접근 
	int countStock;			// default : 같은 패키지 접근
	private int countSold;	// 클래스 내부에서만 접근가능
	
	
	void m() {
		countSold = 100;
	}
}
