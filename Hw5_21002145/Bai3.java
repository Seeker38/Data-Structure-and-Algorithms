package Hw5_21002145;

import java.util.Stack;

public class Bai3<E> extends LinkedBinaryTree<E> {
    public Bai3() {
        super();
    }

    public Bai3(String[] infixExpression) {
        super();
        Stack<Node<E>> operandStack = new Stack<>();
        Stack<Node<E>> operatorStack = new Stack<>();
        operatorStack.push(null); // add a null element to represent the top-level operator
        for (String token : infixExpression) {
            if (isOperand(token)) {
                Node<E> operandNode = createNode((E) token, null, null, null);
                operandStack.push(operandNode);
            } else if (isOperator(token)) {
                while (operatorStack.peek() != null
                        && hasHigherPrecedence(token, operatorStack.peek().getElement().toString())) {
                    Node<E> operatorNode = operatorStack.pop();
                    Node<E> rightChild = operandStack.pop();
                    Node<E> leftChild = operandStack.pop();
                    operatorNode.setLeft(leftChild);
                    operatorNode.setRight(rightChild);
                    leftChild.setParent(operatorNode);
                    rightChild.setParent(operatorNode);
                    operandStack.push(operatorNode);
                }
                Node<E> operatorNode = createNode((E) token, null, null, null);
                operatorStack.push(operatorNode);
            } else if (token.equals("(")) {
                operatorStack.push(null);
            } else if (token.equals(")")) {
                while (operatorStack.peek() != null) {
                    Node<E> operatorNode = operatorStack.pop();
                    Node<E> rightChild = operandStack.pop();
                    Node<E> leftChild = operandStack.pop();
                    operatorNode.setLeft(leftChild);
                    operatorNode.setRight(rightChild);
                    leftChild.setParent(operatorNode);
                    rightChild.setParent(operatorNode);
                    operandStack.push(operatorNode);
                }
                operatorStack.pop(); // remove the opening bracket from the stack
            }
        }
        while (operatorStack.peek() != null) {
            Node<E> operatorNode = operatorStack.pop();
            Node<E> rightChild = operandStack.pop();
            Node<E> leftChild = operandStack.pop();
            operatorNode.setLeft(leftChild);
            operatorNode.setRight(rightChild);
            leftChild.setParent(operatorNode);
            rightChild.setParent(operatorNode);
            operandStack.push(operatorNode);
        }
        root = operandStack.pop();
    }

    private boolean isOperand(String str) {
        return !isOperator(str) && !str.equals("(") && !str.equals(")");
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int getPrecedence(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 3; // Higher precedence than addition and subtraction
        } else if (operator.equals("+") || operator.equals("-")) {
            return 2;
        } else {
            return 1; // Lowest precedence
        }
    }

    private boolean hasHigherPrecedence(String operator1, String operator2) {
        return getPrecedence(operator1) >= getPrecedence(operator2);
    }

    public static void main(String[] args) {
        String[] infixExpression = { "(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")" };
        Bai3<String> expressionTree = new Bai3<>(infixExpression);
        Node<String> root = expressionTree.getRoot();

        // Print the tree in inorder traversal
        System.out.print("Infix: ");
        expressionTree.inorderPrint(root);
        System.out.println();
    }

    public Node<E> getRoot() {
        return root;
    }

    public void inorderPrint(Node<E> p) {
        // in-order traversal of tree with root p
        if (p != null) {
            inorderPrint(p.getLeft());
            System.out.print(p.getElement() + " ");
            inorderPrint(p.getRight());
        }
    }
}