package Java.tuan1;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
        }
    private Node top = null;
    private Node bot = null;
    private int n = 0;
    public void add(T data) {
        // Thêm phần tử vào đầu danh sách
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (bot == null) {
            top = bot = node;
        } else {
            bot.next = node;
            bot = node;
        }
        n++;
    }
    public void addBot(T data) {
        
        // Thêm phần tử vào cuối danh sách
        Node node = new Node();
        node.data = data;
        node.next = null;
    
        if (isEmpty()) {
            top = node;
        } else {
            Node current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        bot = node;
        n++;
        
    }
    public T get(int i) {
        // Lấy phần tử ở vị trí thứ i
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.data;
    }
    public void set(int i, T data){
        // Gán giá trị ở vị trí i bằng data
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        node.data = data;
    }
    public boolean isContain(T data) {
        
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node current = top;
        while (current != null) {
        if (current.data == data) {
           return true;
        }
        current = current.next;
        }
        return false;
    }
    public int size() {
        // Trả lại thông tin số phần tử có trong danh sách
        return n;
    }
    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        if (top == null && bot == null && n == 0) {
            return true;
        }
        return false;
    }
    public T removeTop() {
        
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        if (isEmpty()) {
            throw new RuntimeException("rong");
        }
        T data = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        n--;
        return data;

    }
    public T removeBot() {
        
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        if (isEmpty()) {
            throw new RuntimeException("rong");
        }
        T data = bot.data;
        if (top == bot) {
            top = bot = null;
        } else {
            Node node = top;
            while (node.next != bot) {
                node = node.next;
            }
            node.next = null;
            bot = node;
        }
        n--;
        return data;
    }
    public void remove(T data) {
        // Xóa tất cả các phần tử có giá trị bằng data
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (top.data.equals(data)) {
            top = top.next;
            if (top == null) {
                bot = null;
            }
            n--;
            return;
        }
        Node node = top;
        while (node.next != null && !node.next.data.equals(data)) {
            node = node.next;
        }
        if (node.next == null) {
            throw new RuntimeException("Item not found");
        }
        node.next = node.next.next;
        if (node.next == null) {
            bot = node;
        }
        n--;
    }
        
}


