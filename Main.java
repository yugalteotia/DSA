import part2.tree.Tree;

public class Main {
    public static void main(String[] args) {

        Tree myTree = new Tree();
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(7);
        myTree.insert(2);
        myTree.insert(9);
        myTree.insert(4);
        myTree.insert(1);
        myTree.insert(6);
        myTree.insert(8);

        System.out.println(myTree.find(6));
    }
}