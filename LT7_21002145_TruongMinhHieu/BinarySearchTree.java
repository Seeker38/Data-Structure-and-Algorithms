package LT7_21002145_TruongMinhHieu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    public static class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = min(node.right);
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 1. Kiểm tra một dãy có là dãy duyệt giữa của cây tìm kiếm nhị phân - Inorder Traversal and BST

    static int isRepresentingBST(int arr[], int N) {
        // Given an array arr of size N, write a program that returns 1 if array
        // represents Inorder traversal of a BST, else returns 0.

        Stack<Integer> stack = new Stack<Integer>();

        int min = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int key = arr[i];

            if (key < min) {
                return 0;
            }
            
            while (!stack.empty() && stack.peek() < key) {
                min = stack.pop();
            }
            stack.push(key);
        }
        
        return 1;
    }

    // 2. Kiểm tra xem một cây có là cây tìm kiếm nhị phân - Check for BST
    public boolean isBST(Node root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        // Check if the node's value is within the allowed range for the BST
        if (node.key < minValue || node.key > maxValue) {
            return false;
        }

        // Recursively check if the left and right subtrees are valid BSTs
        return isBSTHelper(node.left, minValue, node.key - 1) && isBSTHelper(node.right, node.key + 1, maxValue);
    }


    // 3. Tìm median của cây tìm kiếm nhị phân - Median of BST
    public static float findMedian(Node root) {
        if (root == null) {
            return 0.0f;
        }

        int n = countNodes(root);

        if (n % 2 == 0) {
            Node left = kthSmallest(root, n / 2);
            Node right = kthSmallest(root, (n / 2) + 1);
            return (float) (left.key + right.key) / 2.0f;
        } else {
            Node node = kthSmallest(root, (n / 2) + 1);
            return (float) node.key;
        }
    }

    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static Node kthSmallest(Node node, int k) {
        if (node == null) {
            return null;
        }
        int leftCount = countNodes(node.left);
        if (k == leftCount + 1) {
            return node;
        } else if (k <= leftCount) {
            return kthSmallest(node.left, k);
        } else {
            return kthSmallest(node.right, k - leftCount - 1);
        }
    }


    // 4. Đếm các giá trị của cây trong khoảng cho trước - Count BST nodes that lie in a given range

    public int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }
        // If current node is in range, add it to count and recursively process left and right children
        if (root.key >= l && root.key <= h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        // If current node is smaller than low value of range, then process only the right child
        if (root.key < l) {
            return getCount(root.right, l, h);
        }
        // If current node is greater than high value of range, then process only the left child
        else {
            return getCount(root.left, l, h);
        }
    }



    // 5. Phần tử nhỏ nhất thứ k trong cây tìm kiếm nhị phân - k-th smallest element in BST


    // public int KthSmallestElement(Node root, int k) {
    // int count = countNodes(root.left);
    // if (k <= count) {
    // return KthSmallestElement(root.left, k);
    // } else if (k > count + 1) {
    // return KthSmallestElement(root.right, k - 1 - count);
    // }
    // return root.key;
    // }
    public int KthSmallestElement(Node root, int K) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        int count = 0;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            count++;
            if (count == K) {
                return node.key;
            }
            node = node.right;
        }
        return -1;
    }

    // 6. Phần tử lớn thứ k trong cây tìm kiếm nhị phân - Kth largest element in BST
    public int kthLargest(Node root, int K) {
        int[] count = { 0 };
        int[] kthLargest = { Integer.MIN_VALUE };
        kthLargestUtil(root, K, count, kthLargest);
        return kthLargest[0];
    }

    private void kthLargestUtil(Node node, int K, int[] count, int[] kthLargest) {
        if (node == null || count[0] >= K) {
            return;
        }

        // Traverse right subtree first
        kthLargestUtil(node.right, K, count, kthLargest);

        // If kth largest is found, simply return the value
        if (++count[0] == K) {
            kthLargest[0] = node.key;
            return;
        }

        // Traverse left subtree next
        kthLargestUtil(node.left, K, count, kthLargest);
    }

    // Các thuật toán tìm kiếm

    // 1. Phần tử bé nhất trên cây tìm kiếm nhị phân - Minimum element in BST
    public int minValue(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The node cannot be null.");
        }

        while (node.left != null) {
            node = node.left;
        }

        return node.key;
    }

    // 2. Tìm phần tử liền sau của một nôt trên cây tìm kiếm nhị phân - Inorder Successor in BST
    public Node inorderSuccessor(Node root, Node x) {
        if (x == null || root == null) {
            return null;
        }

        // if x has a right child, then the inorder successor is the leftmost node in
        // the right subtree
        if (x.right != null) {
            return findMin(x.right);
        }

        // if x does not have a right child, then we need to find the ancestor of x such
        // that x is present in the left subtree of the ancestor
        Node successor = null;
        while (root != null) {
            if (x.key < root.key) {
                successor = root;
                root = root.left;
            } else if (x.key > root.key) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    }

    public static Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // 3. Tìm phần tử liền trước và liền sau của một phần tử trên cây tìm kiếm nhị phân - Predecessor and Successor
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }

        // If key is present at root
        if (root.key == key) {
            // the maximum value in left subtree is predecessor
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                p.pred = tmp;
            }

            // the minimum value in right subtree is successor
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                s.succ = tmp;
            }
            return;
        }

        // If key is smaller than root's key, go to left subtree
        if (key < root.key) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        }
        // If key is greater than root's key, go to right subtree
        else {
            p.pred = root;
            findPreSuc(root.right, p, s, key);
        }
    }

    private class Res {
        public Node pred; // holds predecessor node reference
        public Node succ; // holds successor node reference

        public Res() {
            pred = null;
            succ = null;
        }
    }

    // 4. Tìm giá trị phần tử lớn nhất trên cây tìm kiếm nhị phân mà không vượt quá N - Closest Neighbor in BST
    public static int findMaxForN(Node node, int val) {
        int maxVal = Integer.MIN_VALUE;

        while (node != null) {
            if (node.key <= val) {
                maxVal = Math.max(maxVal, node.key);
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return maxVal;
    }

    // 5. Tìm số bé nhất trên cây tìm kiếm nhị phân mà có giá trị lớn hơn hoặc bằng một giá trị cho trước - Ceil in BST
    int findCeil(Node root, int key) {
        if (root == null)
            return -1;

        // If key is present at root, then ceil is the root
        if (root.key == key)
            return root.key;

        // If key is smaller than root's data, then ceil must be in left subtree
        if (root.key > key) {
            int ceil = findCeil(root.left, key);
            if (ceil == -1 || ceil >= key) {
                return root.key;
            } else {
                return ceil;
            }
        }

        // If key is greater than root's data, then ceil must be in right subtree
        return findCeil(root.right, key);
    }


    // Các phép toán trên cây tìm kiếm nhị phân

    // 1. Tìm kiếm - Search a node in BST
    public boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // 2. Thêm phần tử - Insert a node from BST
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    // 3. Xóa phần tử - Delete a node from BST

    public static Node deleteNode(Node root, int X) {
        if (root == null) {
            return null;
        }

        if (X < root.key) {
            root.left = deleteNode(root.left, X);
        } else if (X > root.key) {
            root.right = deleteNode(root.right, X);
        } else {
            // Case 1: Node has no children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2: Node has one child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }

            // Case 3: Node has two children
            else {
                // Find the minimum value in the right subtree
                Node minNode = findMin(root.right);
                // Replace the node to be deleted with the minimum value in the right subtree
                root.key = minNode.key;
                // Delete the minimum value in the right subtree
                root.right = deleteNode(root.right, minNode.key);
            }
        }
        return root;
    }

    // 4. Xóa mọi phần tử có giá trị lớn hơn k trong cây tìm kiếm nhị phân - Delete nodes greater than k
    public Node deleteNode_K(Node root, int k) {
        if (root == null) {
            return null;
        }

        // Delete nodes from right subtree
        root.right = deleteNode(root.right, k);

        // Delete current node if its value is greater than or equal to k
        if (root.key >= k) {
            return root.left;
        }

        // Delete nodes from left subtree
        root.left = deleteNode(root.left, k);

        return root;
    }

    // 5. Thay đổi khóa phần tử - Change of Key in BST
    public static Node changeKey(Node root, int old_key, int new_key) {
        if (root == null) {
            return null;
        }

        // Find the node with the old key value
        if (old_key < root.key) {
            root.left = changeKey(root.left, old_key, new_key);
        } else if (old_key > root.key) {
            root.right = changeKey(root.right, old_key, new_key);
        } else {
            // If the node with the old key value is found, change it to the new key value
            root.key = new_key;
        }

        return root;
    }

    

    // Biến đổi một cây sang cây tìm kiếm nhị phân - Binary Tree to BST

    Node binaryTreeToBST(Node root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        Collections.sort(values);

        return constructBST(values, 0, values.size() - 1);
    }

    private void inorderTraversal(Node root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, values);
        values.add(root.key);
        inorderTraversal(root.right, values);
    }

    Node constructBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(values.get(mid));
        node.left = constructBST(values, start, mid - 1);
        node.right = constructBST(values, mid + 1, end);

        return node;
    }

    // Kiểm tra một dãy có là kết quả của phép duyệt trước trên cây tìm kiếm nhị phân - Preorder Traversal and BST
    public static int canRepresentBST(int arr[], int N) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (arr[i] < max) {
                return 0;
            }

            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                max = stack.pop();
            }

            stack.push(arr[i]);
        }

        return 1;
    }

    // Tạo cây tìm kiếm nhị phân từ các phép duyệt sau - Construct BST from Postorder
    public static Node constructTree(int post[], int n) {
        if (post == null || n == 0) {
            return null;
        }
        // Create root node
        Node root = new Node(post[n - 1]);

        // Find index of the last element which is greater than root
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (post[i] > root.key) {
                break;
            }
        }

        // Recursively construct right subtree
        root.right = constructTree(Arrays.copyOfRange(post, i + 1, n - 1), n - i - 2);

        // Recursively construct left subtree
        root.left = constructTree(Arrays.copyOfRange(post, 0, i + 1), i + 1);

        return root;
    }

    // Chuyển đổi phép duyệt tiền tố thành hậu tố - Preorder to Postorder
    public static Node pre_to_post(int[] pre, int start, int end) {
        if (start > end) {
            return null;
        }

        Node root = new Node(pre[start]);

        if (start == end) {
            return root;
        }

        int i;
        for (i = start + 1; i <= end; i++) {
            if (pre[i] > root.key) {
                break;
            }
        }

        // Construct left and right subtrees recursively
        root.left = pre_to_post(pre, start + 1, i - 1);
        root.right = pre_to_post(pre, i, end);

        return root;
    }

    public static Node pre_to_post(int[] pre) {
        return pre_to_post(pre, 0, pre.length - 1);
    }
}