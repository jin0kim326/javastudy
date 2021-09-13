package prob5;

public class MyStack {
	private int pointer;
	private int stackSize;
	private String stringArr[];
	
	public MyStack(int stackSize) {
		pointer = -1;  						// pointer 초기화
		stackSize= this.stackSize;			// stack의 크기 설
		stringArr = new String[stackSize];	// stack 생성 
	}
	
	public boolean isEmpty() {
		if (pointer == -1 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		 return pointer == stackSize-1 ? true : false; 
	}
	
	public void push(String pushString) {
		if (isFull()) {
			return;
		} else {
			stringArr[++pointer]= pushString;
		}
	}
	
	public String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어져있어 pop 불가");
			return null;
		} else {
			String DeleteStr = stringArr[pointer];
			stringArr[pointer] = "";
			return DeleteStr;
		}
	}
	
}