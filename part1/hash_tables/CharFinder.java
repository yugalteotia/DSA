package part1.hash_tables;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CharFinder {

    public static Character findFirstNonRepeatingCharacter(String inp) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        // or we can use hashMap but then we have to iterate over the charArray of
        // string to check if its value is 1 in map because hashMap do not preserve the
        // order.

        for (Character ch : inp.toCharArray())
            if (!map.containsKey(ch))
                map.put(ch, 1);
            else
                map.put(ch, map.get(ch) + 1);

        for (Entry<Character, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                return entry.getKey();
        return null;
    }

    public static Character findFirstRepeatedCharacter(String inp) {

        Set<Character> mySet = new HashSet<>();

        for (char ch : inp.toCharArray()) {
            if (mySet.contains(ch))
                return ch;
            mySet.add(ch);
        }

        return null;
    }
}