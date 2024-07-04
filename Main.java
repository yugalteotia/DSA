import part2.tree.TreeAndQ1toQ6;

public class Main {
    public static void main(String[] args) {

        TreeAndQ1toQ6 myTree = new TreeAndQ1toQ6();
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(9);
        myTree.insert(1);
        myTree.insert(6);
        myTree.insert(8);
        myTree.insert(10);

        // myTree.swapRoot();

        System.out.println(myTree.areSiblingsQ5(4, 8));
    }
}