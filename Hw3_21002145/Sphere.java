package Hw3_21002145;

public class Sphere extends Shape {
    private double radius = 0;

    public Sphere(double radius) {
        // Hàm khởi tạo
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        // Hoàn thành thân hàm
        return 4 / 3 * Math.PI * Math.pow(radius, 3);
    }

    @Override
    protected double getArea() {
        // Hoàn thành thân hàm
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return "Sphere [radius=" + radius + ", P=" + getVolume() + "]";
    }

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return "Sphere";
    }

}