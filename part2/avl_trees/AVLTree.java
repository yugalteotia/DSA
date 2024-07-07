package part2.avl_trees;

public class AVLTree {

    private class AVLNode {

        private AVLNode leftChild;
        private AVLNode rightChild;
        private int data;
        private int height;

        public AVLNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data= " + data;
        }
    }

    private AVLNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private AVLNode insert(AVLNode root, int data) {

        if (root == null)
            return new AVLNode(data);

        if (data < root.data)
            root.leftChild = insert(root.leftChild, data);
        else
            root.rightChild = insert(root.rightChild, data);

        root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));

        if (isLeftHeavy(root)) {
            System.out.println(root + "     left heavy");
        }

        if (isRightHeavy(root)) {
            System.out.println(root + "     right heavy");
        }

        return root;
    }

    private boolean isLeftHeavy(AVLNode root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root) {
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(AVLNode root) {
        return root == null ? 0 : getHeight(root.leftChild) - getHeight(root.rightChild);
    }

    private int getHeight(AVLNode root) {
        return root != null ? root.height : -1;
    }

}