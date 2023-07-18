package Hw5_21002145;

import java.io.*;

public class BinaryTreeExample {
    public static void main(String[] args) {
        // Create the binary tree
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> node1 = tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> node2 = tree.addLeft(node1, 5);
        LinkedBinaryTree.Node<Integer> node3 = tree.addRight(node1, 3);
        LinkedBinaryTree.Node<Integer> node4 = tree.addLeft(node2, 8);
        LinkedBinaryTree.Node<Integer> node5 = tree.addRight(node2, 6);
        LinkedBinaryTree.Node<Integer> node6 = tree.addLeft(node3, 2);
        LinkedBinaryTree.Node<Integer> node7 = tree.addRight(node3, 7);

        LinkedBinaryTree.Node<Integer> root = node1;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            printTreeHorizontallyToFile(root, "", writer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Print the binary tree horizontally on console
    public static void printTreeHorizontally(LinkedBinaryTree.Node<Integer> node, String indent) {
        if (node != null) {
            printTreeHorizontally(node.getRight(), indent + "    ");
            System.out.println(indent + node.getElement());
            printTreeHorizontally(node.getLeft(), indent + "    ");
        }
    }

    // Print the binary tree horizontally to file
    public static void printTreeHorizontallyToFile(LinkedBinaryTree.Node<Integer> node, String indent,
            BufferedWriter writer) throws IOException {
        if (node != null) {
            printTreeHorizontallyToFile(node.getRight(), indent + "    ", writer);
            writer.write(indent + node.getElement());
            writer.newLine();
            printTreeHorizontallyToFile(node.getLeft(), indent + "    ", writer);
        }
    }

}