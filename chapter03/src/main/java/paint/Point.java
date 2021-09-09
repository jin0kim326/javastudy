package paint;

public class Point {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println("점[x="+x+", y="+y+"]을 그렸습니다.");
	}
	
	// 이런 불필요한 메소드는 만들지말자 
//	public void disappear() {
//		System.out.println("점[x="+x+", y="+y+"]을 지워졌습니다.");
//	}
	
	public void show(boolean visible) {
		if(visible) {
//			System.out.println("점[x="+x+", y="+y+"]을 그렸습니다.");
			show();
		} else {
			System.out.println("점[x="+x+", y="+y+"]을 지워졌습니다.");
		}
	}
}
