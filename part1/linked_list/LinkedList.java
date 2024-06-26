package part1.linked_list;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data) {

        Node newNode = new Node(data);

        if (isListEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            Node temp = head;
            head = newNode;
            head.setNext(temp);
        }
        size++;
    }

    public void addLast(int data) {

        Node newNode = new Node(data);

        if (isListEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            tail.setNext(newNode);
            tail = newNode;

        }
        size++;
    }

    public void deleteFirst() {
        if (isListEmpty())
            throw new NoSuchElementException("The list is already empty, you can't remove any node from the list");

        if (deleteIfSingleNode())
            return;

        head = head.getNext();
        size--;
    }

    public void deleteLast() {

        if (isListEmpty())
            throw new NoSuchElementException("The list is already empty, you can't remove any node from the list");

        if (deleteIfSingleNode())
            return;

        Node curr = head;

        while (curr.getNext().getNext() != null) {
            curr = curr.getNext();
        }

        curr.setNext(null);
        tail = curr;
        size--;

    }

    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    public int indexOf(int data) {

        Node curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.getData() == data) {
                return index;
            }
            index++;
            curr = curr.getNext();
        }

        return -1;
    }

    public void reverse() {

        if (isListEmpty() || size == 1)
            return;

        Node prevoius = null;
        Node current = head;
        Node nextNode = head.getNext();

        while (nextNode != null) {
            current.setNext(prevoius);
            prevoius = current;
            current = nextNode;
            nextNode = nextNode.getNext();
        }

        current.setNext(prevoius);
        swapHeadAndTail();

    }

    public int getLastKthNode(int k) {

        if (isListEmpty())
            throw new IllegalStateException("The list is empty");
        if (k > size || k <= 0)
            throw new IllegalArgumentException("You can not ask for the element at undefined position");

        Node curr = head;
        Node resNode = head;

        while (curr != null) {
            if (k-- <= 0)
                resNode = resNode.getNext();
            curr = curr.getNext();
        }

        return resNode.getData();
    }

    public int[] getMiddleElements() {

        if (isListEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        // As simple as if fast moves 2 times and ends at null then there are even
        // numbers
        // and if fast moves 1 time and ends at null then there are odd numbers
        // PS: moving is per iteration

        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        if (fast == null)
            return new int[] { slow.getData() };
        return new int[] { slow.getData(), slow.getNext().getData() };
    }

    public boolean hasLoop() {

        if (isListEmpty())
            return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.tail;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.tail.setNext(node);

        return list;
    }

    private void swapHeadAndTail() {
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isListEmpty() {
        return size == 0 || head == null || tail == null;
    }

    private boolean deleteIfSingleNode() {
        if (head == tail) {
            head = tail = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isListEmpty())
            return "LinkedList [head=" + "null" + ", tail=" + "null" + ", isListEmpty()=" + isListEmpty()
                    + ", toString()=" + "\"\"" + "]";
        return "LinkedList [head=" + head.getData() + ", tail=" + tail.getData() + ", isListEmpty()=" + isListEmpty()
                + ", toString()="
                + toStringHelper() + "]";
    }

    private String toStringHelper() {

        StringBuffer str = new StringBuffer();
        Node curr = head;

        while (curr.getNext() != null) {
            str.append(curr.getData()).append("->");
            curr = curr.getNext();
        }
        str.append(curr.getData());
        return str.toString();
    }
}