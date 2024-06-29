package part1.queue;

import java.util.Arrays;

public class ArrayQueue {

    private int[] array;
    private int rear;
    private int front;
    private int noOfItems;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
    }

    public void enqueue(int data) {

        if (isFull()) {
            throw new IllegalStateException("The queue is full");
        }

        array[rear++] = data;
        // the below opertion is to reset rear to 0 if array is not full so that
        // remaning space can be utilized
        rear = rear % array.length;
        noOfItems++;
    }

    private boolean isFull() {
        return noOfItems == array.length;
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }

        int result = array[front];
        array[front++] = 0;
        // the below opertion is to circulate the front if array is not full and front
        // is going out of bound
        front = front % array.length;
        noOfItems--;
        return result;
    }

    private boolean isEmpty() {
        return noOfItems == 0;
    }

    @Override
    public String toString() {
        return "ArrayQueue [Queue=" + Arrays.toString(array) + ", rear=" + rear + ", front=" + front + ", noOfItems="
                + noOfItems + "]";
    }
}
