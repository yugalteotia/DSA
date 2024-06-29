package part1.queue;

import java.util.ArrayDeque;
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

        Queue<Integer> result = new ArrayDeque<Integer>();

        while (k-- != 0)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            result.add(stack.pop());

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }

        queue = result;
        System.out.println(queue);
    }

}