package part1.array;

public class ArrayQ1 extends Array {

    public ArrayQ1(int size) {
        super(size);
    }

    public int max() {
        int maxEle = Integer.MIN_VALUE;
        for (int ele : arr)
            if (ele >= maxEle)
                maxEle = ele;
        return maxEle;
    }
}
