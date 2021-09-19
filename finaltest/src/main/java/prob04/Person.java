package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	public Person () { 
		this(12,"");
	}
	
	public Person ( String name) {
		this(12, name);		
	}
	
	
	public Person (int age, String name) {
		this.age = age;	
		this.name = name;
		numberOfPerson +=1;	// 생성자호출시 인구수 1증가 
	}
	
	public void selfIntroduce() {
		System.out.println("내이름은 "+ name +" 이며, 나이는 "+ age +"살입니다.");
	}
	
	public static int getPopulation() { 
		return numberOfPerson;
	}
}
