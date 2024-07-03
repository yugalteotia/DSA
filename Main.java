import part2.tree.Tree;

public class Main {
    public static void main(String[] args) {

        Tree myTree = new Tree();
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(9);
        myTree.insert(1);
        myTree.insert(6);
        myTree.insert(8);
        myTree.insert(10);
        System.out.println("\nPre:-\n");
        myTree.traversePreOrder();
        System.out.println("\nIn:-\n");
        myTree.traverseInOrder();
        System.out.println("\nPost:-\n");
        myTree.traversePostOrder();

        System.out.println("\nheight:-\n");
        System.out.println(myTree.height());

        System.out.println("\nmin:-\n");
        System.out.println(myTree.min());
    }
}