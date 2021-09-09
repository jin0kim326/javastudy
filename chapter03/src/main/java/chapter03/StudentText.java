package chapter03;

public class StudentText {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		
		Person p1 = s1;		//Upcasting(암시적, Implicity)
		p1.setName("둘리");
		// ((Person)s1).setName("둘리");
		
		Student s2 = (Student)p1;	//Downcating(명시적, explicity) 
		s2.setMajor("cs");
	}

}
