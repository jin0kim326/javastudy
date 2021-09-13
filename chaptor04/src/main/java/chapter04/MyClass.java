package chapter04;

public class MyClass {
	private static MyClass instance = null;
	
	private MyClass() {
		
	}
	
	
	// Singleton + Factory Method(메소드를 통해 객체를 생성)
	public static MyClass getInstance() {
		if(instance == null) { 
			return new MyClass();
		} 
		return instance;
	}
}
