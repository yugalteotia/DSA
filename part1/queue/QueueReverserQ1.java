package part1.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverserQ1 {

    private static Stack<Integer> stack = new Stack<>();

    public static void reverse(Queue<Integer> queue) {

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void reverse(Queue<Integer> queue, int k) {

        int toBeReverse = k;

        while (toBeReverse-- != 0)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        int notToBeReverse = queue.size() - k;

        while (notToBeReverse-- != 0) {
            queue.add(queue.remove());
        }
    }
}