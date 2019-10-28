package hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import linkedList.Node;

import java.util.NoSuchElementException;

public class Hashtable<K, V> {

    private LinkedList<Entry<K, V>>[] hashtable;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private static final int HASH_PRIME_NUMBER = 599;

    // Define an entry in the hash table that holds the key and value pair
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // Constructor for hashtable that initialize the array of linked list to have an initial size
    public Hashtable() {
        this.hashtable = new LinkedList[DEFAULT_INITIAL_CAPACITY];
    }

    // turns the key into a hash code that will be used as the index to place the entry in the table
    private int hash(K key) {
        String keyAsString = key.toString();
        int sumOfASCIIValues = 0;
        for (int i = 0; i < keyAsString.length(); i++) {
            sumOfASCIIValues += (int)keyAsString.charAt(i);
        }
        int tableSize = hashtable.length;
        int hashCode = (sumOfASCIIValues * HASH_PRIME_NUMBER) % tableSize;
        return hashCode;
    }

    // add a key value pair into the hashtable
    public boolean add(K key, V value) {
        if (contains(key)) {
            return false;
        }
        Entry newEntry = new Entry(key, value);
        int hashCode = hash(key);
        if (hashtable[hashCode] == null) {
            hashtable[hashCode] = new LinkedList<>();
        }
        hashtable[hashCode].add(newEntry);
        return true;
    }

    // takes in a key and return the value from the table
    public V get(K key) {
        int hashCode = hash(key);
        if (hashtable[hashCode] == null) {
            return null;
        }
        LinkedList<Entry<K, V>> list = hashtable[hashCode];
        for (Entry entry: list) {
            if (entry.getKey().equals(key)) {
                return (V)entry.getValue();
            }
        }
        return null;
    }

    // takes in a key and return a boolean, indicating if the key exists in the table already
    public boolean contains(K key) {
        int hashCode = hash(key);
        if (hashtable[hashCode] == null) {
            return false;
        }
        LinkedList<Entry<K, V>> list = hashtable[hashCode];
        for (Entry entry: list) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
}
