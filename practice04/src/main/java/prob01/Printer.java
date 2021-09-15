package prob01;

public class Printer {
	
	/*
	public void println(int integer) {
		System.out.println(integer);	
	}
	
	public void println(boolean bool) {
		System.out.println(bool);
	}
	
	public void println(double db) {
		System.out.println(db);
	}
	
	public void println(String str) {
		System.out.println(str);
	}
	*/
	
//	public <T> void println(T t) {
//		System.out.println(t);
//	}
	
	public <T> void println(T... ts) {
		for (T t : ts) {
				System.out.println(t);
		}
	}
	
	
	public int sum (int... nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i ;
		}
		return sum;
	}
}
