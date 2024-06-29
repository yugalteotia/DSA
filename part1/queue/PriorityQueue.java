package part1.queue;

import java.util.Arrays;

public class PriorityQueue {

    private int noOfItems;
    private int[] array;

    public PriorityQueue(int size) {
        array = new int[size];
    }

    public void add(int data) {

        if (noOfItems == array.length)
            increaseSize();

        array[shiftItemsToInsert(data)] = data;
        noOfItems++;
    }

    public int remove() {

        if (noOfItems <= 0)
            throw new IllegalStateException("The queue is empty");

        if (noOfItems < array.length / 2)
            decreaseSize();

        int result = array[0];

        int i;
        for (i = 0; i < noOfItems - 1; i++)
            array[i] = array[i + 1];

        array[i] = 0;
        noOfItems--;

        return result;
    }

    private int shiftItemsToInsert(int data) {
        int i;
        for (i = noOfItems - 1; i >= 0; i--) {
            if (array[i] > data) {
                array[i + 1] = array[i];
                continue;
            }
            break;
        }
        return i + 1;
    }

    private void decreaseSize() {

        int[] newArray = new int[array.length / 2];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void increaseSize() {

        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public String toString() {
        return "PriorityQueue [noOfItems=" + noOfItems + ", array=" + Arrays.toString(array) + "]";
    }
}
