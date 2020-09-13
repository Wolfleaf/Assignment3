package assign03;

public class Rectangle extends Shape{

	private double area;
	private double perimeter;
	private String name = "Rectangle";	
	
	public Rectangle(double width, double length) {
		this.area = width * length;
		this.perimeter = (width * 2) + (length * 2);
	}
	
	public double getPerimeter() {
		return perimeter;
	}

	public double getArea() {
		return area;
	}

	public String toString() {
		return name + "\t" + "Perimeter: " + perimeter + "\t" + "Area: " + area; 
	}
}
