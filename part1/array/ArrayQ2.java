package part1.array;

public class ArrayQ2 extends Array {

    public ArrayQ2(int size) {
        super(size);
    }

    public int[] intersect(int[] anotherArray) {

        int[] resultArray = new int[Math.max(anotherArray.length, arr.length)];
        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < anotherArray.length; j++)
                if (arr[i] == anotherArray[j])
                    resultArray[resultIndex++] = arr[i];

        return resultArray;
    }
}