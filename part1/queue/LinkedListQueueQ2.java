package part1.queue;

import part1.linked_list.Node;

public class LinkedListQueueQ2 {

    private int noOfItems;
    private Node front;
    private Node rear;

    public LinkedListQueueQ2() {
        front = rear = null;
    }

    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (isEmpty()) {
            rear = front = newNode;
            noOfItems++;
            return;
        }

        rear.setNext(newNode);
        rear = newNode;
        noOfItems++;

    }

    public int dequeue() {

        if (isEmpty())
            throw new IllegalStateException("The queue is already empty");

        int result;
        if (front == rear) {
            result = front.getData();
            front = rear = null;
            noOfItems--;
            return result;
        }
        result = front.getData();
        front = front.getNext();
        noOfItems--;
        return result;
    }

    public int peek() {
        return front.getData();
    }

    public int size() {
        return noOfItems;
    }

    private boolean isEmpty() {
        return rear == front && rear == null;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "LinkedList [front=" + "null" + ", rear=" + "null" + ", isListEmpty()=" + isEmpty()
                    + ", toString()=" + "\"\"" + "]";
        return "LinkedList [front=" + front.getData() + ", rear=" + rear.getData() + ", isListEmpty()=" + isEmpty()
                + ", toString()="
                + toStringHelper() + "]";
    }

    private String toStringHelper() {

        StringBuffer str = new StringBuffer();
        Node curr = front;

        while (curr.getNext() != null) {
            str.append(curr.getData()).append("->");
            curr = curr.getNext();
        }
        str.append(curr.getData());
        return str.toString();
    }
}
