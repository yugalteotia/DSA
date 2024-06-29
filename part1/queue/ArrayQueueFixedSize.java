package part1.queue;

import java.util.Arrays;

public class ArrayQueueFixedSize {

    private int size;
    private int[] queue;
    private int front;
    private int rear;

    public ArrayQueueFixedSize(int capacity) {
        this.size = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int data) {

        if (isFull())
            throw new IllegalStateException("The queue is already full");

        queue[rear++] = data;
    }

    public int dequeue() {

        if (isEmpty())
            throw new IllegalStateException("The queue is already empty");

        int result = queue[front];
        queue[front++] = 0;
        return result;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return front == rear || front >= size;
    }

    public boolean isFull() {
        return front > rear || rear >= size;
    }

    @Override
    public String toString() {
        return "ArrayQueue [size=" + size + ", queue=" + Arrays.toString(queue) + ", front=" + front + ", rear=" + rear
                + "]";
    }

}
