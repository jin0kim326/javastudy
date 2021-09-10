package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		// == 는 두 객체의 "동일성"을 비교하는 연산
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		
		//eqauls : 두 객체의 "동질성" (내용비교)
		//		   부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같음.
		//		   equals를 오버라이드 하면 동질성 비교가능.
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
	}
}
