package part1.array;

public class ArrayQ3 extends Array {

    public ArrayQ3(int size) {
        super(size);
    }

    public void reverse() {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
