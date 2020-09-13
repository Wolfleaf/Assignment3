package assign03;

public class Circle extends Shape{

	private double area;
	private double perimeter;
	private String name = "Circle";
	
	public Circle(double diameter) {
		this.area = Math.PI * ((diameter / 2) * (diameter / 2));
		this.perimeter = Math.PI * diameter;
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
