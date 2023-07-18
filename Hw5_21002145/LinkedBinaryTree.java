package Hw5_21002145;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child
        // Constructs a node with the given element and neighbors. ∗/

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            // Sinh viên hoàn thiện phương thức
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;

        }

        public E getElement() {
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }

        // Additional methods
        public boolean isLeaf() {
            return (left == null) && (right == null);
        }
    }

    Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    // update methods
    public Node<E> addRoot(E element) {
        // Add element to root of an empty tree
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        root = createNode(element, null, null, null);
        size = 1;
        return root;

    }

    public Node<E> addLeft(Node p, E element) {
        // Add element to left child node of p if empty
        if (p.getLeft() != null) {
            throw new IllegalArgumentException("Node already has a left child");
        }
        Node<E> child = createNode(element, p, null, null);
        p.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node p, E element) {
        // Add element to right child node of p if empty
        if (p.getRight() != null) {
            throw new IllegalArgumentException("Node already has a right child");
        }
        Node<E> child = createNode(element, p, null, null);
        p.setRight(child);
        size++;
        return child;
    }

    public void set(Node p, E element) {
        // set element to nnode p
        p.setElement(element);
    }

    @Override
    public E root() {
        // TODO Auto-generated method stub
        return root.getElement();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public int numChildren(E p) {
        Node<E> node = validate(p);
        int count = 0;
        if (node.getLeft() != null) {
            count++;
        }
        if (node.getRight() != null) {
            count++;
        }
        return count;
    }

    @Override
    public E parent(E p) {
        Node<E> node = validate(p);
        return node.getParent().getElement();
    }

    @Override
    public E left(E p) {
        Node<E> node = validate(p);
        if (node.getLeft() == null) {
            return null;
        }
        return node.getLeft().getElement();
    }

    @Override
    public E right(E p) {
        Node<E> node = validate(p);
        if (node.getRight() == null) {
            return null;
        }
        return node.getRight().getElement();
    }

    @Override
    public E sibling(E p) {
        Node<E> node = validate(p);
        Node<E> parent = node.getParent();
        if (parent == null) {
            return null;
        }
        if (node == parent.getLeft()) {
            if (parent.getRight() == null) {
                return null;
            }
            return parent.getRight().getElement();
        } else {
            if (parent.getLeft() == null) {
                return null;
            }
            return parent.getLeft().getElement();
        }
    }

    private Node<E> validate(E p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position type.");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("The node is no longer in the tree.");
        }
        return node;
    }

    protected void attach(Node<E> node, Node<E> leftChild, Node<E> rightChild) {
        node.setLeft(leftChild);
        node.setRight(rightChild);
        if (leftChild != null) {
            leftChild.setParent(node);
        }
        if (rightChild != null) {
            rightChild.setParent(node);
        }
        size += 2;
    }

}