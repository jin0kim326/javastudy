package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		String ks1 = "one";
		m.put(ks1, 1);		// auto boxing => 인티저객체가 들어가야하는데 기본int 1을 넣고있음 => new Integer(1) 과 동일하다생각하면된다~
		m.put("two", 2);
		m.put("three", 3);
		
		
		int i = m.get("one");		// auto unboxing
		int j = m.get(new String("one"));
		System.out.println(i+":"+j);
		// => key값은 다른객체여도 값만 같으면 똑같음
		
		m.put("three", 333333);	// 동일한 키에 다른값을 넣으면 "덮어쓰기"
		System.out.println(m.get("three"));
		
		// 순회 
		Set<String> keys = m.keySet();
		for(String key : keys) {
			System.out.println(m.get(key));
		}
	}

}
