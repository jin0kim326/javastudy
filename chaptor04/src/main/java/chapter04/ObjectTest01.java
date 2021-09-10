package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10 , 20);
		
		//Class klass = p.getClass();
		
		
		System.out.println(p.getClass());	// reflection(반사)
		System.out.println(p.hashCode());	// 객체의 address 기반 hashing값 
		System.out.println(p.toString());	// getClass() + "@" + hashCode()
		System.out.println(p);				// p.toString() 과 같음!!
	}

}
