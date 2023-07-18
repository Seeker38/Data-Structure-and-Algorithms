package Hw3_21002145;

import java.util.ArrayList;
import java.util.Scanner;

public class Complex {
    private float real; // phần thực
    private float image; // phần ảo

    public Complex(float r, float i) {
        real = r;
        image = i;
        // Hàm khởi tạo
    }

    public Complex add(Complex c) {
        // Cộng số phức hiện tại với số phức c
        return new Complex(real + c.real, image + c.image);
    }

    public Complex minus(Complex c) {
        // Trừ số phức hiện tại cho số phức c
        return new Complex(real - c.real, image - c.image);
    }

    public Complex time(Complex c) {
        // Nhân số phức hiện tại với số phức c
        return new Complex(real * c.real - image * c.image, image * c.real + real * c.image);
        // (a +bi) (c+ di) = ac+ adi + bci -bd
    }

    public float realpart() {
        return real;
    }

    public float imagepart() {
        return image;
    }

    @Override
    public String toString() {
        if (image == 0) {
            return String.valueOf(image);
        }
        if (real == 0) {
            return image + "i";
        }
        return real + " + " + image + "i";
        // In ra số phức
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n so phuc: ");
        int n = sc.nextInt();
        int i = 0;
        ArrayList<Complex> complexs = new ArrayList<>();
        while (i < n) {
            System.out.println("Nhap lan luot real va image: ");
            Complex num = new Complex(sc.nextInt(), sc.nextInt());
            complexs.add(num);
            i++;
        }

        System.out.println("Tim so phuc o vi tri thu: ");
        int find = sc.nextInt();
        sc.close();
        for (int j = 0; j < complexs.size(); j++) {
            if (find == j) {
                System.out.println(complexs.get(j).toString());
            }
        }

        System.out.println("tong " + n + " so phuc: ");
        System.out.println(sumCom(complexs).toString());

        System.out.println("Ung dung tinh tich cua " + n + " so phuc");
        System.out.println(multiplyCom(complexs).toString());

    }

    public static Complex sumCom(ArrayList<Complex> complexs) {
        Complex sum = new Complex(0, 0);
        for (int i = 0; i < complexs.size(); i++) {
            sum = sum.add(complexs.get(i));
        }

        return sum;
    }

    public static Complex multiplyCom(ArrayList<Complex> complexs) {
        Complex sum = new Complex(1, 0);
        for (int i = 0; i < complexs.size(); i++) {
            sum = sum.time(complexs.get(i));
        }

        return sum;
    }
}
