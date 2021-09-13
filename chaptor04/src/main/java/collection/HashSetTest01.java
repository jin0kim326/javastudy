package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);
		
		
		System.out.println(s.size());
		System.out.println(s.contains("둘리"));
		System.out.println(s.contains(s2));			
		// => 자료구조이기때문에 s1,s2는 다른객체이지만(s2는 아예 hastSet에 들어있지않음) 똑같은 "둘리"라는 자료를 가지고 있기때문에
		// true 를 반환한다!
		
		// 순회 1 
		for (String str : s) {
			System.out.println(str);
		}
		
	}

}
