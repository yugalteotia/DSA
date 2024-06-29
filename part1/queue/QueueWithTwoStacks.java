package part1.queue;

import part1.stack.TwoStacksQ1;

public class QueueWithTwoStacks {

    private TwoStacksQ1 stack;
    private int count;
    private int size;

    public QueueWithTwoStacks(int size) {
        this.size = size;
        stack = new TwoStacksQ1(size * 2);
    }

    public void enqueue(int data) {

        if (isFull())
            throw new IllegalStateException("queue is full");

        stack.push1(data);
        count++;
    }

    public int dequeue() {

        if (isEmpty())
            throw new IllegalStateException("The queue is already empty");

        moveStack1ToStack2();

        int result = stack.pop2();
        count--;

        moveStack2ToStack1();

        return result;
    }

    public int peek() {

        moveStack1ToStack2();

        int result = stack.peek1();
        count--;

        moveStack2ToStack1();

        return result;
    }

    public boolean isEmpty() {
        return stack.isEmpty1();
    }

    private boolean isFull() {
        return count == size;
    }

    private void moveStack1ToStack2() {
        while (!stack.isEmpty1()) {
            stack.push2(stack.pop1());
        }
    }

    private void moveStack2ToStack1() {
        while (!stack.isEmpty2()) {
            stack.push1(stack.pop2());
        }
    }

    @Override
    public String toString() {
        return "QueueUsingStack [Queue=" + stack + ", count=" + count + ", size=" + size + "]";
    }

}