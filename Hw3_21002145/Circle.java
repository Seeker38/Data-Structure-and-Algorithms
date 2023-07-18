package Hw3_21002145;

public class Circle extends Shape {
    private double radius = 0;

    public Circle(double radius) {
        // Hàm khởi tạo
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        // Hoàn thành thân hàm
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double getPerimeter() {
        // Hoàn thành thân hàm
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", P=" + getPerimeter() + "]";
    }

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return "Circle";
    }

}
