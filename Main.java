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
        System.out.println(myTree.getNodesAtDistance(0));
        System.out.println(myTree.getNodesAtDistance(1));
        System.out.println(myTree.getNodesAtDistance(2));

        myTree.levelOrderTraversel();
    }
}