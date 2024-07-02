package part1.hash_tables;

import java.util.Arrays;

public class HashTableLinearProbingQ4 {

    private class Entry {

        private int key;
        private String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "\nEntry [key=" + key + ", value=" + value + "]";
        }
    }

    private Entry[] entries;
    private int noOfItems;

    public HashTableLinearProbingQ4(int capacity) {
        entries = new Entry[capacity];
    }

    public void put(int key, String value) {

        if (noOfItems >= entries.length)
            throw new IllegalStateException("The hashmap is already full");

        int startingIndex = getHash(key);
        Entry newEntry = new Entry(key, value);

        int i;
        for (i = startingIndex; i < entries.length; i++, i %= noOfItems) {
            if (entries[i] != null && entries[i].key == key) {
                entries[i].value = value;
                return;
            }
            if (entries[i] == null) {
                entries[i] = newEntry;
                noOfItems++;
                return;
            }
        }
    }

    public Entry get(int key) {

        int startingIndex = getHash(key);

        int i;
        for (i = startingIndex; i < entries.length; i++, i %= noOfItems)
            if (isEntryMatched(key, startingIndex, i)) {
                return entries[i];
            }

        return null;
    }

    public Entry remove(int key) {

        int startingIndex = getHash(key);

        int i;
        for (i = startingIndex; i < entries.length; i++, i %= noOfItems)
            if (isEntryMatched(key, startingIndex, i)) {
                Entry resultEntry = entries[i];
                entries[i] = null;
                noOfItems--;
                return resultEntry;
            }

        return null;
    }

    public int size() {
        return this.noOfItems;
    }

    private boolean isEntryMatched(int key, int startingIndex, int i) {
        return entries[i] != null && getHash(entries[i].key) == startingIndex && entries[i].key == key;
    }

    private int getHash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return "HashTableLinearProbingQ4 [entries=" + Arrays.toString(entries) + ",\n\nnoOfItems=" + noOfItems
                + ", size()=" + size() + "]";
    }

}
