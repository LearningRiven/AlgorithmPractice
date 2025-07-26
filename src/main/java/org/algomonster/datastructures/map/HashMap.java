package org.algomonster.datastructures.map;

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
        private final K key;
        private V value;
        private MapEntry<K,V> next;

        public MapEntry(){
            this.key = null;
            this.value = null;
            this.next = null;
        }

        public MapEntry(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public MapEntry<K,V> getNext(){
            return this.next;
        }

        public void setNext(MapEntry<K, V> next){
            this.next = next;
        }

        public V getValue(){
            return this.value;
        }

        public void setValue(V value){
            this.value = value;
        }

        @Override
        public String toString(){
            return this.key + "=" + this.value;
        }

        @Override
        //Basic hashing function, follows standard JDK practices while being hashmap K V specific
        public int hashCode(){
            int result = this.key == null ? 0 : this.key.hashCode();
            //Basically selects a prime number, multiplies it by the key hashcode, and adds the value hashcode to the final value
            return 31 * result + (value == null ? 0 : value.hashCode());
        }
    }
}
