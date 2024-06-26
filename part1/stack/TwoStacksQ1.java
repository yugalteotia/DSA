import java.util.Arrays;
import java.util.EmptyStackException;

public class TwoStacksQ1 {
    private int[] stack;
    private int size;
    private int top1 = -1;
    private int top2 = -1;

    public TwoStacksQ1(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push1(int data) {

        if (isFull()) {
            resize();
        }

        if (top2 > top1) {
            top1 = top2;
            stack[++top1] = data;
        } else {
            stack[++top1] = data;
        }
    }

    public void push2(int data) {

        if (isFull()) {
            resize();
        }

        if (top1 > top2) {
            top2 = top1;
            stack[++top2] = data;
        } else {
            stack[++top2] = data;
        }
    }

    public int pop() {

        if (isEmpty())
            throw new EmptyStackException();

        int result = stack[top1];
        stack[top1--] = 0;
        return result;
    }

    public int peek() {
        return stack[top1];
    }

    public boolean isEmpty() {
        return top1 == -1;
    }

    public boolean isFull() {
        return top1 == size - 1 || top2 == size - 1;
    }

    private void resize() {
        this.size *= 2;
        int[] newStack = new int[size];
        for (int i = 0; i < stack.length; i++)
            newStack[i] = stack[i];
        stack = newStack;
    }

    @Override
    public String toString() {
        return "Stack [stack=" + Arrays.toString(stack) + ", size=" + size + ", top=" + top1 + "]";
    }

}
