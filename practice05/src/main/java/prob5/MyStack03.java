package prob5;

public class MyStack03<T> {
	private int pointer;
	private T[] objectArr;
	
	@SuppressWarnings("unchecked")
	public MyStack03(int stackSize) {
		pointer = -1;  						// pointer 초기화
		objectArr = (T[]) new Object[stackSize];	// stack 생성 
	}
	
	public boolean isEmpty() {
		return pointer == -1;
	}
	
	public boolean isFull() {
		 return pointer == objectArr.length - 1; 
	}
	
	public void push(T t) {
		if (isFull()) {
			resized();
		} 
			objectArr[++pointer]= t;
		
	}
	
	public T pop() throws MyStackException{
		if (isEmpty()) {
			throw new MyStackException("Stack is Empty");			
		} 
			T t = objectArr[pointer];
			objectArr[pointer--] = null;
			return t;
	}
	
	public void resized() {
		T[] temp = (T[]) new Object[objectArr.length * 2];
		for (int i=0; i<= pointer; i++) {
			temp[i] = objectArr[i];
		}
			objectArr = temp;
	}
}
