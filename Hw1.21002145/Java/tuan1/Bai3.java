package Java.tuan1;

import java.util.Scanner;

public class Bai3 {
    double real;
    double imagine;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input 1st real number: ");
        double real1 = sc.nextDouble();
        System.out.print("input 1st imagine number: ");
        double imagine1 = sc.nextDouble();
        System.out.print("input 2nd real number: ");
        double real2 = sc.nextDouble();
        System.out.print("input 2nd real number: ");
        double imagine2 = sc.nextDouble();
        sc.close();
        Bai3 n1 = new Bai3(real1, imagine1);
        Bai3 n2 = new Bai3(real2, imagine2);
        
        Bai3 temp1 = new Bai3();
        temp1 = temp1.add(n1, n2);
        System.out.println(temp1.toString());
        
        Bai3 temp2 = new Bai3();
        temp2 = temp2.multiply(n1, n2);
        System.out.println(temp2.multiply(n1, n2));
    }
    public Bai3(double real, double imagine){
        this.real = real;
        this.imagine = imagine;
    }
    public Bai3(){}
    
    public Bai3 add(Bai3 num1, Bai3 num2){
        return new Bai3(num1.real+num2.real, num1.imagine + num2.imagine);
    }
    public Bai3 multiply(Bai3 num1, Bai3 num2)
    {
        
        return new Bai3(num1.real*num2.real - num1.imagine* num2.imagine, num1.imagine*num2.real + num1.real*num2.imagine );
    }

    public  double getReal() {
        return real;
    }
    public  void setReal(double real) {
        this.real = real;
    }
    public  double getImagine() {
        return imagine;
    }
    public  void setImagine(double imagine) {
        this.imagine = imagine;
    }
    public  void setNum(double real,double imagine) {
        setImagine(imagine);
        setReal( real);
    }
    @Override
    public String toString() {
        return real + " + " + imagine + "i";
    } 
    
}
