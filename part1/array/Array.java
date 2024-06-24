package part1.array;

import java.util.Arrays;

public class Array {

    protected int[] arr;
    private int size;
    private int ptr = 0;

    public Array(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void insert(int data) {
        if (ptr == size)
            increaseSize();
        arr[ptr++] = data;
    }

    protected void increaseSize() {
        size *= 2;
        int[] newArr = new int[size];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];
        arr = newArr;
    }

    public boolean remove(int data) {
        int i;
        for (i = 0; i < size; i++)
            if (arr[i] == data) {
                shiftLeft(i);
                return true;
            }
        return false;
    }

    private void shiftLeft(int i) {
        for (int j = i; j < size - 1; j++)
            arr[j] = arr[j + 1];
        arr[size - 1] = 0;
        ptr--;
    }

    public void removeAt(int index) {
        if (index >= ptr || index < 0)
            throw new IllegalArgumentException();
        shiftLeft(index);
    }

    public int indexOf(int data) {
        for (int i = 0; i < size; i++)
            if (arr[i] == data)
                return i;
        return -1;
    }

    @Override
    public String toString() {
        return "Array [arr=" + Arrays.toString(arr) + ", size=" + size + ", ptr=" + ptr + "]";
    }

}
