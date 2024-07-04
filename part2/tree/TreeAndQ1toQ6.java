package part2.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeAndQ1toQ6 {

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

        if (root == null) // dry run asuming either of left or right child of a node is null but not both.
                          // technically its not a leaf node. if we return -1 than it will be definetely
                          // neglected by the Math.max(-1, 'something maybe > 0 but not 0 or even if its 0
                          // too its greater than -1'). We can also return 0 it wont matter becoz min(0,
                          // 0) is still 0.
            return -1;

        if (isLeafNode(root)) // leafNode is a node which can only have both left and right childrens equals
                              // to null.
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        try {
            return moshMin(root);
        } catch (Exception e) {
            System.out.println("In moshMin the error is:- " + e + "\n");
            return myMin(root);
        }
    }

    private int moshMin(Node root) {

        if (isLeafNode(root))
            return root.data;

        var leftMin = moshMin(root.leftChild);
        var rightMin = moshMin(root.rightChild);

        return Math.min(Math.min(leftMin, rightMin), root.data);

    }

    private int myMin(Node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (isLeafNode(root)) {
            return root.data;
        }

        return Math.min(Math.min(myMin(root.leftChild), myMin(root.rightChild)), root.data);
    }

    private boolean isLeafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean equals(TreeAndQ1toQ6 other) {

        return other != null ? areNodesEqual(this.root, other.root) : false;
    }

    private boolean areNodesEqual(Node currentRoot, Node otherRoot) {

        if (currentRoot == null && otherRoot == null) { // if both are not null or only one of them is null then next
                                                        // condition
            return true;
        }

        if (currentRoot == null || otherRoot == null) { // if anyone of them is null obviously other wont be null as we
                                                        // have checked both null in above condition then instantly
                                                        // false
            return false;
        }

        if (currentRoot.data != otherRoot.data) { // if both above conditoins are false means both the nodes have some
                                                  // data, so why not check them if the data is equal or not
            return false;
        }

        return areNodesEqual(currentRoot.leftChild, otherRoot.leftChild)
                && areNodesEqual(currentRoot.rightChild, otherRoot.rightChild);
    }

    public void swapRoot() {
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {

        if (root == null)
            return true;

        if (min > root.data || max < root.data)
            return false;

        return isBST(root.leftChild, min, root.data - 1) && isBST(root.rightChild, root.data + 1, max);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> nodesAtDistanceList = new ArrayList<>();
        getNodesAtDistance(root, distance, nodesAtDistanceList);
        return nodesAtDistanceList;
    }

    private void getNodesAtDistance(Node root, int distance, List<Integer> list) {

        if (root == null || distance < 0)
            return;

        if (distance == 0)
            list.add(root.data);

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void levelOrderTraversel() {
        for (int i = 0; i <= height(); i++)
            for (var nodeData : getNodesAtDistance(i))
                System.out.println(nodeData);
    }

    public int getSizeQ1() {
        return getSizeQ1(root);
    }

    private int getSizeQ1(Node root) {

        if (root == null)
            return 0;

        return 1 + getSizeQ1(root.leftChild) + getSizeQ1(root.rightChild);
    }

    public int countLeavesQ2() {
        return countLeavesQ2(root);
    }

    private int countLeavesQ2(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        return countLeavesQ2(root.leftChild) + countLeavesQ2(root.rightChild);
    }

    public int maxQ3() {
        return maxQ3(root);
    }

    private int maxQ3(Node root) {

        if (root == null)
            return Integer.MIN_VALUE;

        if (isLeafNode(root)) {
            return root.data;
        }

        return Math.max(Math.max(maxQ3(root.leftChild), maxQ3(root.rightChild)), root.data);
    }

    public boolean containsQ4(int inpData) {

        return containsQ4(root, inpData);
    }

    private boolean containsQ4(Node root, int inpData) {

        if (root == null)
            return false;

        if (root.data == inpData)
            return true;

        return containsQ4(root.leftChild, inpData) || containsQ4(root.rightChild, inpData);
    }

    public boolean areSiblingsQ5(int leftData, int rightData) {
        return areSiblingsQ5(root, leftData, rightData);
    }

    private boolean areSiblingsQ5(Node root, int leftData, int rightData) {

        if (root == null || isLeafNode(root) || root.leftChild == null || root.rightChild == null)
            return false;

        if ((root.leftChild.data == leftData && root.rightChild.data == rightData)
                || (root.rightChild.data == leftData && root.leftChild.data == rightData)) {
            return true;
        }

        return areSiblingsQ5(root.leftChild, leftData, rightData)
                || areSiblingsQ5(root.rightChild, leftData, rightData);
    }

    public List<Integer> getAncestorsQ6(int data) {
        List<Integer> ancestorsList = new ArrayList<>();
        getAncestorsQ6(root, data, ancestorsList);
        return ancestorsList;
    }

    private void getAncestorsQ6(Node root, int data, List<Integer> list) {

        // 6- Implement a method to return the ancestors of a value in a List<Integer>.

        if (root == null) {
            return;
        }

        if (root.data != data) {
            getAncestorsQ6(root.leftChild, data, list);
            getAncestorsQ6(root.rightChild, data, list);
        } else
            list.add(root.data);

    }
}