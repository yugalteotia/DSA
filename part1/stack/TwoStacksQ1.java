package part1.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TwoStacksQ1 {
    private int[] stack;
    private int size;
    private int top1 = -1;
    private int top2;

    public TwoStacksQ1(int size) {
        this.size = size;
        top2 = size;
        stack = new int[size];
    }

    public void push1(int data) {

        if (isFull())
            throw new StackOverflowError("The stack is already full, can not add more elements!!!");

        stack[++top1] = data;
    }

    public void push2(int data) {

        if (isFull())
            throw new StackOverflowError("The stack is already full, can not add more elements!!!");

        stack[--top2] = data;
    }

    public int pop1() {

        if (isEmpty1())
            throw new EmptyStackException();

        int result = stack[top1];
        stack[top1--] = 0;
        return result;
    }

    public int pop2() {

        if (isEmpty2())
            throw new EmptyStackException();

        int result = stack[top2];
        stack[top2++] = 0;
        return result;
    }

    public int peek1() {
        return stack[top1];
    }

    public int peek2() {
        return stack[top2];
    }

    public boolean isEmpty1() {
        return top1 <= -1;
    }

    public boolean isEmpty2() {
        return top2 >= size;
    }

    public boolean isFull() {
        return top1 >= top2;
    }

    // private void resize() {
    // this.size *= 2;
    // int[] newStack = new int[size];
    // for (int i = 0; i < stack.length; i++)
    // newStack[i] = stack[i];
    // stack = newStack;
    // }

    @Override
    public String toString() {
        var stack1 = Arrays.copyOfRange(stack, 0, top1 + 1);
        var stack2 = Arrays.copyOfRange(stack, top2, size);
        return "TwoStacks [stack1=" + Arrays.toString(stack1) + ", top1=" + top1 + ", " + "stack2="
                + Arrays.toString(stack2) + ", top2=" + top2
                + ", Totalsize=" + size + "]";
    }

}
