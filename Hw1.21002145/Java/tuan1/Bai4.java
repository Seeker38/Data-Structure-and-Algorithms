package Java.tuan1;

public class Bai4 {
    double r; 
    double x, y, z;
    public Bai4(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public double area(){

        return Math.PI * 4.0 *Math.pow( r,2);
        
    }
    public double volume(){
        return Math.PI * (4.0/3.0) * Math.pow(r,3);
    }
    

    @Override
    public String toString() {
        return "Bai4 [r=" + r + ", x=" + x + ", y=" + y + ", z=" + z + "]";
    }
    public String checkStatus(Bai4 s1, Bai4 s2){
        double d = Math.sqrt( Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2) + Math.pow(s1.z - s2.z, 2));

        if (d <= s1.r - s2.r){
            return "cau 1 bao cau 2";
        }
        else if (d <= s2.r - s1.r){
            return "cau 2 bao cau 1";
        }
        else if (d < s1.r + s2.r){
            return "2 cau giao nhau";
        }
        else if (d == s1.r + s2.r){
            return "2 cau tiep xuc";
        }
        return "2 cau nam ngoai nhau";
    }
    public static void main(String[] args) {
        Bai4 s1 = new Bai4(2, 2, 2, 2);
        Bai4 s2 = new Bai4(3, 0, 0, 0);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println("area of s1: " + s1.area());
        System.out.println("area of s2: " + s2.area());
        System.out.println("volume of s1: " + s1.volume());
        System.out.println("volume of s2: " + s2.volume());
        System.out.println(s1.checkStatus(s1, s2));

    }
}
