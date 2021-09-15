package prob6;

public class RectTriangle extends Shape {
	
	public RectTriangle(double width, double height) {
		super(width,height);
	}
	
	@Override
	public double getArea() {
		return getWidth() * getHeight() * 1/2;
	}
	
	@Override
	public double getPerimeter() {
		double clen = Math.sqrt( Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));
		double perimeter = getWidth() + getHeight() + clen;
		return perimeter;
	}
}
