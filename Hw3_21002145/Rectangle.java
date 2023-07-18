package Hw3_21002145;

public class Rectangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Rectangle(double width, double height) {
        // Hàm khởi tạo
        this.width = width;
        this.height = height;

    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        // Hoàn thành thân hàm
        return width * height;
    }

    @Override
    protected double getPerimeter() {
        // Hoàn thành thân hàm
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + ", P=" + getPerimeter() + "]";
    }

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return "Rectangle";
    }

}