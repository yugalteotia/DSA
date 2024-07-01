package part1.hash_tables;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    private class Entry {

        private int key;
        private String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry [key=" + key + ", value=" + value + "]";
        }

    }

    private LinkedList<Entry>[] entries;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        entries = new LinkedList[size];
    }

    public void put(int key, String value) {

        var newEntry = new Entry(key, value);

        if (entries[hash(key)] == null)
            entries[hash(key)] = new LinkedList<>();
        // agar mai bucket = entires[hash(key)] ko upar hi initialize karleta then
        // bucket == null check karta to koi dikat nai thi par agar mai bucket = new
        // LinkedList<>() kar deta to dikat thi kyuki fir compiler bucket nam ka
        // reference jo phele entries[hash(key)] ko point kar rha tha usko vha se
        // dereference karke naye naye linkelist ke object pe refer/point kar deta and
        // even after adding new entry to bucket vo naye LL ke object me add hoti
        // entries[hash(key)] me nahi

        var bucket = entries[hash(key)];
        for (Entry entry : bucket)
            if (entry.key == key) {
                entry.value = value;
                return;
            }

        bucket.add(newEntry);
    }

    public Entry get(int key) {

        var bucket = entries[hash(key)];

        if (bucket == null)
            throw new IllegalAccessError("There is no list at the specified location");

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry;
            }
        }

        return null;
    }

    public boolean remove(int key) {

        var bucket = entries[hash(key)];
        
        if (bucket == null)
            throw new IllegalAccessError("There is no list at the specified location");

        for (Entry entry : bucket)
            if (entry.key == key) {
                bucket.remove(entry);
                return true;
            }
        return false;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return "HashTable [entries=" + Arrays.toString(entries) + "]";
    }
}