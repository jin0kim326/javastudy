package prob6;

public class Rectangle extends Shape implements Resizable {
	public Rectangle(double width, double height) {
		super(width,height);
	}
	
	@Override
	public void resize(double s) {
		super.setWidth( getWidth() * s );
		super.setHeight( getHeight() * s);
	}
	
	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}
	
	@Override
	public double getPerimeter() {
		double perimeter =  (getWidth() + getHeight()) * 2;
		return perimeter;
	}
}
