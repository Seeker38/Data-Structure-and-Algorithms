package Hw3_21002145;

import java.util.ArrayList;

public class ShapeTest {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Rectangle rec = new Rectangle(10, 5);
        Circle cir = new Circle(5);
        Sphere sphere = new Sphere(6);
        shapes.add(rec);
        shapes.add(cir);
        shapes.add(sphere);

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }

        System.out.println();
        // ung dung khac: tim dien tich cua cac hinh
        System.out.println("Area cua cac hinh la:");
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + "[S=" + shape.getArea() + "]");
        }

    }
}
