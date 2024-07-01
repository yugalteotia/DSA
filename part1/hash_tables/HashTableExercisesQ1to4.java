package part1.hash_tables;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableExercisesQ1to4 {

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

        // bruteForce
        // for (int i = 0; i < arr.length - 1; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // if (Math.abs(arr[i] - arr[j]) == diff)
        // noOfPairs++;
        // }
        // }

        
        return noOfPairs;
    }

}