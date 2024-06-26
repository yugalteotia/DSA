import java.util.Arrays;
import java.util.EmptyStackException;

public class StackByArray {

    private int[] stack;
    private int size;
    private int top = -1;

    public StackByArray(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push(int data) {

        if (isFull()) {
            resize();
        }

        stack[++top] = data;
    }

    public int pop() {

        if (isEmpty())
            throw new EmptyStackException();

        int result = stack[top];
        stack[top--] = 0;
        return result;
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
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
        return "Stack [stack=" + Arrays.toString(stack) + ", size=" + size + ", top=" + top + "]";
    }

}
