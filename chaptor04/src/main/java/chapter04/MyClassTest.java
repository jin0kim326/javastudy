package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		
		// Myclass myClass0 = new MyClass();  
		// MyClass 의 생성자가 private로 선언되어있기 때문에 생성불가
		
		String str1 = new String("테스트");
		String str2 = new String("테스트");
		System.out.println(str1==str2);
		
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		System.out.println(myClass1 == myClass2);
	}

}
