package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근시 클래스명 생략가능
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	static void s1() {
		// Error : static 메소드에서는 instance 변수에 접근 불가
		//System.out.println(n);
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		System.out.println(m);
		// 같은 클래스에서는 클래스(static) 변수 접근시 클래스명 생략가능
	}
	
	static void s3() {
		// Error : static method에서는 instance 메소드에 접근 불가
		//f1(); 
	}
	
	static void s4() {
		StaticMethod.s1();
		s1();
	}
}
