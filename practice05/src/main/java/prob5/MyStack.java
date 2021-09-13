package prob5;

public class MyStack {
	private int pointer;
	private int stackSize;
	private String stringArr[];
	
	public MyStack(int stackSize) {
		pointer = -1;
		stackSize= this.stackSize;
		stringArr = new String[stackSize];
	}
	
	public static void push(String str) {
		stringArr[++pointer] = str;
	}
}