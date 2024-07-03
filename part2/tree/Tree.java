package part2.tree;

public class Tree {

    private class Node {

        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
        }

    }

    private Node root = null;

    public void insert(int data) {

        Node current = root;
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        while (true) {
            if (data < current.data) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                } else
                    current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                } else
                    current = current.rightChild;
            }
        }

    }

    public boolean find(int value) {

        Node current = root;

        while (current != null) {

            if (value == current.data)
                return true;

            if (value < current.data)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {

        if (root == null)
            return;

        System.out.println(root.data);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {

        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.data);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {

        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.data);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {

        if (root == null)
            return -1;

        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {

        if (isLeafNode(root))
            return root.data;

        var leftMin = min(root.leftChild);
        var rightMin = min(root.rightChild);

        return Math.min(Math.min(leftMin, rightMin), root.data);
    }

    private boolean isLeafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
