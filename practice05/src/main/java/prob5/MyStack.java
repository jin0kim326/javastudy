package prob5;

public class MyStack {
	private int pointer;
	private String stringArr[];
	private int stackSize;
	
	public MyStack(int stackSize) {
		pointer = -1;  						// pointer 초기화
		stringArr = new String[stackSize];	// stack 생성 
	}
	
	public boolean isEmpty() {
		return pointer == -1;
	}
	
	public boolean isFull() {
		 return pointer == stringArr.length - 1;
	}
	
	public void push(String pushString) {
		if (isFull()) {
			resized();
		} 
			stringArr[++pointer]= pushString;
		
	}
	
	public String pop() throws MyStackException{
		if (isEmpty()) {
			throw new MyStackException("Stack is Empty");			
		} 
			String deleteStr = stringArr[pointer];
			stringArr[pointer--] = null;
			return deleteStr;
	}
	
	public void resized() {
		String[] temp = new String[stringArr.length * 2];
		for (int i=0; i<= pointer; i++) {
			temp[i] = stringArr[i];
		}
			stringArr = temp;
	}
	
	
}