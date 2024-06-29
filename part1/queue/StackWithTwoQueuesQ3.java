package part1.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueuesQ3 {

    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private boolean isQ1Main = true;

    public void push(int data) {

        if (isQ1Main)
            q1.add(data);
        else
            q2.add(data);
    }

    public int pop() {

        if (isEmpty())
            throw new IllegalStateException("The stack is already empty!!!");

        if (isQ1Main) {
            pushingQ1ToQ2ExceptLastElement();

            isQ1Main = false;
            return q1.remove();
        }

        pushingQ2ToQ1ExceptLastElement();
        isQ1Main = true;
        return q2.remove();
    }

    public int peek() {

        if (isEmpty())
            throw new IllegalStateException("The stack is empty!!!");

        if (isQ1Main) {
            pushingQ1ToQ2ExceptLastElement();
            int res = q1.peek();
            q2.add(q1.remove()); // adding the last item to secondaryStack as we just need to peek the element
                                 // not to change its posi
            isQ1Main = false;
            return res;
        }

        pushingQ2ToQ1ExceptLastElement();
        int res = q2.peek();
        q1.add(q2.remove()); // adding the last item to secondaryStack as we just need to peek the element
                             // not to change its posi
        isQ1Main = true;
        return res;
    }

    private void pushingQ2ToQ1ExceptLastElement() {
        while (q2.size() - 1 != 0) {
            q1.add(q2.remove());
        }
    }

    private void pushingQ1ToQ2ExceptLastElement() {
        while (q1.size() - 1 != 0) {
            q2.add(q1.remove());
        }
    }

    public boolean isEmpty() {
        return q1.size() == 0 && q2.size() == 0;
    }

    @Override
    public String toString() {
        return "StackWithTwoQueuesQ3 [q1=" + q1 + ", q2=" + q2 + "]";
    }

}
