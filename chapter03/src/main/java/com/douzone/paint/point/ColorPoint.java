package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;
	
//	public ColorPoint() {
//		super();
//	} => Point 클래스에가서 생성자를만들어준다
	
	public ColorPoint(int x, int y, String color) {
		
//		setX(x);
//		setY(y); ==> setter를 안쓰고 아래라인처럼 할수있음
		super(x,y);		//부모 클래스의 생성자를 호출
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color=" + color + "]을 그렸습니다");
	}	
}
