package LT7_21002145_TruongMinhHieu;

public class Res {
    public Node pred; // holds predecessor node reference
    public Node succ; // holds successor node reference
    
    public class Node {
        int key;
        Node left, right;
        
        Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    public Res() {
        pred = null;
        succ = null;
    }
}




