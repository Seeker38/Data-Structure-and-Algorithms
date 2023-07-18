package Hw4_21002145;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a chain of words: ");
        String str = sc.nextLine();

        String[] words = str.split("");
        sc.close();
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        LinkedListStack<String> stack = new LinkedListStack<>();
        
        for (String word : words) {
            queue.enqueue(word);
            stack.push(word);
        }
        
        boolean isPalindrome = true;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            String front = queue.dequeue();;
            String back = stack.pop();
            if (!front.equals(back)) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
