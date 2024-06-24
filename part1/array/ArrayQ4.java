package part1.array;

public class ArrayQ4 extends Array {

    public ArrayQ4(int size) {
        super(size);
    }

    public void insertAt(int index, int data) {
        if (index >= arr.length || index < 0)
            throw new IllegalArgumentException();
        if (index >= arr.length)
            increaseSize();
        shiftRight(index);
        arr[index] = data;
    }

    private void shiftRight(int index) {
        for (int i = arr.length - 1; i > index; i--)
            arr[i] = arr[i - 1];
    }
}
