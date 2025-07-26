package org.algomonster.datastructures.map;

import java.util.Map;

public class HashMap<K, V> {
    // Inner class here: private static class MapEntry<K, V> { ... } with your refinements (immutable key, manual equals/hashCode without Objects)

    public HashMap() {
        // Constructor: Initialize internal storage (e.g., array of MapEntry chains)
    }

    public void put(K key, V value) {
        // Add or update key-value pair
    }

    public V get(K key) {
        // Retrieve value for key, or null if absent
        return null;
    }

    public V remove(K key) {
        // Remove and return value for key, or null if absent
        return null;
    }

    public boolean containsKey(K key) {
        // Check if key exists
        return false;
    }

    public int size() {
        // Return number of entries
        return -1;
    }

    public boolean isEmpty() {
        // Check if no entries
        return false;
    }

    public void clear() {
        // Remove all entries
    }

    /**
     * MapEntry structure for the hashmap class
     */
    private static class MapEntry<K,V>{
        private K key;
        private V value;
        public MapEntry<K,V> next;

        private MapEntry(){
            this.key = null;
            this.value = null;
            this.next = null;
        }

        private MapEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public MapEntry<K,V> getNext(){
            return this.next;
        }

        public void setNext(K key, V value){
            this.next = new MapEntry<K,V>(key,value);
        }
    }
}
