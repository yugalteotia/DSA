import part1.linked_list.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addFirst(23);
        ll.addFirst(45);
        ll.addFirst(763);
        ll.addFirst(9);
        ll.addFirst(29);
        ll.addFirst(69);
        System.out.println(ll);
        System.out.println(ll.hasLoop());

        var list = LinkedList.createWithLoop();
        System.out.println(list.hasLoop());
    }
}