package Hw4_21002145;

import java.util.Scanner;

public class HanoiTower {
    public static int n;
    private static ArrayStack[] tower;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // dynamicStack. = new ArrayStack<Integer>();
        // LinkedListStack<Integer> s2 = new LinkedListStack<>();
        // LinkedListStack<Integer> s3 = new LinkedListStack<>();

        n = sc.nextInt();
        sc.close();
        towersOfHanoi(n);
        // display();

    }

    public static void towersOfHanoi(int n) {

        // create three stacks, tower[0] is scratch
        tower = new ArrayStack[4];
        for (int i = 0; i <= 3; i++) {
            tower[i] = new ArrayStack(4);
        }
        for (int d = n; d > 0; d--) {
            // initialize
            // add disk d to tower 1
            tower[1].push(d);
        }
        // move n disks from tower 1 to 2 using 3 as
        // intermediate tower
        display();
        move(n, 1, 2, 3);
    }

    public static void move(int n, int a, int b, int c) {
        if (n > 0) {
            move(n - 1, a, c, b);
            int d = (int) tower[a].pop();
            tower[c].push(d);
            System.out.println("Move disk " + d + " from tower "+ a + " to top of tower " + b);
            //display();
            move(n - 1, b, a, c);
        }
    }

    /* Function to display */
    public static void display() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = n - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(tower[1].get(i));
            } catch (Exception e) {
            }
            try {
                d2 = String.valueOf(tower[2].get(i));
            } catch (Exception e) {
            }
            try {
                d3 = String.valueOf(tower[3].get(i));
            } catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("\n");
    }
}
