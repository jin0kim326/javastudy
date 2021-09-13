package chapter04;

import sun.util.calendar.BaseCalendar.Date;

public class WrapperClassTest01 {
	public static void main (String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		
		/*
		Date day = new Date();
		int hours= day.getHours();
		*/
		
		
		// Auto Boxing : 자동으로 객체를 박싱해 
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		// Auto Unboxing
		//int m = j1.intValue() + 10;
		int m = j1 + 10;
		System.out.println(m);
		
	}

}
