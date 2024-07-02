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
            } else {a
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

}
