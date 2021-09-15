package prob5;


/*
 * MyStack의 String 으로 받던 변수 Object로 
 * */
public class MyStack02 {
	private int pointer;
	private Object objectArr[];
	
	public MyStack02(int stackSize) {
		pointer = -1;  						// pointer 초기화
		objectArr = new Object[stackSize];	// stack 생성 
	}
	
	public boolean isEmpty() {
		return pointer == -1;
	}
	
	public boolean isFull() {
		 return pointer == objectArr.length - 1; 
	}
	
	public void push(String pushString) {
		if (isFull()) {
			resized();
		} 
			objectArr[++pointer]= pushString;
		
	}
	
	public Object pop() throws MyStackException{
		if (isEmpty()) {
			throw new MyStackException("Stack is Empty");			
		} 
			Object deleteObj = objectArr[pointer];
			objectArr[pointer--] = null;
			return deleteObj;
	}
	
	public void resized() {
		Object[] temp = new Object[objectArr.length * 2];
		for (int i=0; i<= pointer; i++) {
			temp[i] = objectArr[i];
		}
			objectArr = temp;
	}
	
}
