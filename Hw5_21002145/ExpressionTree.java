package Hw5_21002145;

import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public ExpressionTree() {
        super();
    }

    public ExpressionTree(String postfixExpression) {
        super();
        Stack<Node<E>> stack = new Stack<>();
        String[] tokens = postfixExpression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                Node<E> rightChild = stack.pop();
                Node<E> leftChild = stack.pop();
                Node<E> operatorNode = createNode((E) token, null, leftChild, rightChild);
                // Set the parent of the left and right children to the operator node
                leftChild.setParent(operatorNode);
                rightChild.setParent(operatorNode);
                stack.push(operatorNode);
            } else {
                Node<E> operandNode = createNode((E) token, null, null, null);
                stack.push(operandNode);
            }
        }
        // The last item on the stack is the root of the expression tree
        root = stack.pop();
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public int evaluate(Node<E> p) {
        if (isOperator(p.getElement().toString())) {
            int leftResult = evaluate(p.getLeft());
            int rightResult = evaluate(p.getRight());
            switch (p.getElement().toString()) {
                case "+":
                    return leftResult + rightResult;
                case "-":
                    return leftResult - rightResult;
                case "*":
                    return leftResult * rightResult;
                case "/":
                    return leftResult / rightResult;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + p.getElement());
            }
        } else {
            // p is an operand node
            return Integer.parseInt(p.getElement().toString());
        }
    }

    public void preorderPrint(Node<E> p) {
        // pre-order traversal of tree with root p
        if (p != null) {
            System.out.print(p.getElement() + " ");
            preorderPrint(p.getLeft());
            preorderPrint(p.getRight());
        }
    }

    public void postorderPrint(Node<E> p) {
        // post-order traversal of tree with root p
        if (p != null) {
            postorderPrint(p.getLeft());
            postorderPrint(p.getRight());
            System.out.print(p.getElement() + " ");
        }
    }

    public void inorderPrint(Node<E> p) {
        // in-order traversal of tree with root p
        if (p != null) {
            inorderPrint(p.getLeft());
            System.out.print(p.getElement() + " ");
            inorderPrint(p.getRight());
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public static void main(String[] args) {
        // Bai 2.2

        ExpressionTree<String> expressionTree = new ExpressionTree<>("6 2 / 3 + 7 4 - *");
        Node<String> root = expressionTree.getRoot();

        // Print the tree in preorder traversal
        System.out.print("Prefix: ");
        expressionTree.preorderPrint(root);
        System.out.println();

        // Print the tree in postorder traversal
        System.out.print("Postfix: ");
        expressionTree.postorderPrint(root);
        System.out.println();

        // Print the tree in inorder traversal
        System.out.print("Infix: ");
        expressionTree.inorderPrint(root);
        System.out.println();


        

        // Bai 2.3

        // ExpressionTree<String> expressionTree = new ExpressionTree<>("6 2 / 3 + 7 4 - *");
        // Node<String> root = expressionTree.getRoot();

        // // Print the tree in preorder traversal
        // System.out.print("Prefix: ");
        // expressionTree.preorderPrint(root);
        // System.out.println();

        // // Print the tree in postorder traversal
        // System.out.print("Postfix: ");
        // expressionTree.postorderPrint(root);
        // System.out.println();

        // // Print the tree in inorder traversal
        // System.out.print("Infix: ");
        // expressionTree.inorderPrint(root);
        // System.out.println();

        // // Compute the value of the expression tree
        // int result = expressionTree.evaluate(root);
        // System.out.println("Result: " + result);

    }

}