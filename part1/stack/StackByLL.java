import part1.linked_list.LinkedList;

public class StackByLL {

    LinkedList stack;

    public StackByLL() {
        stack = new LinkedList();
    }

    public void push(int data) {
        stack.addLast(data);
    }

    public int pop() {
        int result = stack.getLastKthNode(1);
        stack.deleteLast();
        return result;
    }

    public int peek() {
        return stack.getLastKthNode(1);
    }

    public boolean isEmpty() {
        return stack.isListEmpty();
    }

    @Override
    public String toString() {
        return "Stack [" + stack + "]";
    }

}
