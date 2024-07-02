package part1.hash_tables;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableExercisesQ1to3 {

    public int mostFrequent(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int element : arr)
            if (map.containsKey(element))
                map.put(element, map.get(element) + 1);
            else
                map.put(element, 1);

        int prevValue = -1;
        int result = arr[0];

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > prevValue) {
                result = entry.getKey();
                prevValue = entry.getValue();
            }
        }
        return result;
    }

    public String mostFrequentString(String inp) {

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String element : inp.split(" "))
            if (map.containsKey(element))
                map.put(element, map.get(element) + 1);
            else
                map.put(element, 1);

        int prevValue = 0;
        String prevKey = "";

        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > prevValue) {
                prevKey = entry.getKey();
                prevValue = entry.getValue();
            }
        }
        return prevKey;
    }

    public int countPairsWithDiff(int[] arr, int diff) {

        int noOfPairs = 0;

        // bruteForceApproach
        // for (int i = 0; i < arr.length - 1; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // if (Math.abs(arr[i] - arr[j]) == diff)
        // noOfPairs++;
        // }
        // }

        // setApproach
        // Set<Integer> mySet = new HashSet<>();
        // for (int item : arr)
        // mySet.add(item);
        // System.out.println(mySet);
        // for (int item : arr) {
        // if (mySet.contains(item + diff))
        // noOfPairs++;
        // if (mySet.contains(item - diff))
        // noOfPairs++;
        // mySet.remove(item);
        // }

        // mapApproach
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (myMap.containsKey(arr[i] + diff)) {
                noOfPairs++;
                myMap.put(arr[i] + diff, myMap.get(arr[i] + diff) + 1);
            } else {
                myMap.put(arr[i] + diff, 1);
            }
            if (myMap.containsKey(arr[i] - diff)) {
                myMap.put(arr[i] - diff, myMap.get(arr[i] - diff) + 1);
                noOfPairs++;
            } else {
                myMap.put(arr[i] - diff, 1);
            }
        }
        return noOfPairs;
    }

    public int[] twoSum(int[] inp, int target) {

        // bruteForce O(n2)
        // finds indices of only the first single sum pair of target
        int[] result = new int[2];
        for (int i = 0; i < inp.length - 1; i++)
            for (int j = i + 1; j < inp.length; j++)
                if (inp[i] + inp[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
        return null;

        // hashSet() O(n)
        // finds all the pairs of sum
        // List<int[]> list = new LinkedList<>();
        // Set<Integer> mySet = new HashSet<>();
        // for (int item : inp) {
        // mySet.add(item);
        // }
        // for (int i = 0; i < inp.length; i++) {
        // if (mySet.contains(target - inp[i]) ){
        // list.add(new int[] {inp[i], target - inp[i]});
        // }
        // }
        // return list;

        // hashMap() O(n)
        // finds all two sum indices
        // List<int[]> list = new LinkedList<>();
        // Map<Integer, Integer> myMap = new HashMap<>();
        // for (int i = 0; i < inp.length; i++) {
        // if (myMap.containsKey(target - inp[i])) {
        // list.add(new int[] { myMap.get(target - inp[i]), i });
        // }
        // myMap.put(inp[i], i);
        // }
        // return list;
    }
}