package org.algomonster.datastructures.map;

import java.util.Map;
import java.util.Objects;

public class HashMap<K, V> {

    private MapEntry<K,V>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16; //power of 2 for & masking
    private static final float LOAD_FACTOR = 0.75f;
    private int threshold;

    public HashMap() {
        this.buckets = new MapEntry[INITIAL_CAPACITY];
        this.size = 0;
        this.threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }

    public void put(K key, V value) {
        //Index for the bucket, use 0 if key is null, power of 2 capacity allows bitwise operation instead of modulo for efficiency
        //Fixed 0 for null keys, null values dont matter
        int index = this.getIndex(key, this.buckets);
        MapEntry<K,V> entry = this.traverseBucket(buckets[index], key);

        if(entry != null){
            entry.setValue(value);
        }
        else{
            entry = new MapEntry<>(key,value);
            if(buckets[index] != null){
                buckets[index].setPrevious(entry);
                entry.setNext(buckets[index]);
                buckets[index] = entry;
            }
            else{
                buckets[index] = entry;
            }
            this.size++;
        }

        //Do we need to resize?
        if(this.size > threshold){
            resize();
        }
    }

    public V get(K key) {
        V value;
        int index = this.getIndex(key, this.buckets);

        //Traverse the bucket
        MapEntry<K,V> head = this.traverseBucket(buckets[index], key);

        //Handle key matching scenario, replace the value
        if(head != null && (head.key == key || (head.key != null && head.key.equals(key)))){
            return head.getValue();
        }
        //We didnt find a match, meaning we just have to append it to the end by creating a new entry
        else{
            return null;
        }
    }

    public V remove(K key) {
        V value;
        int index = this.getIndex(key, this.buckets);

        //Traverse the bucket
        MapEntry<K,V> head = this.traverseBucket(buckets[index], key);

        if(head != null && (head.key == key || (head.key != null && head.key.equals(key)))){
            //Middle of the chain
            if(head.getPrevious() != null && head.getNext() != null){
                head.getNext().setPrevious(head.getPrevious());
                head.getPrevious().setNext(head.getNext());
            }
            //Start of the chain
            else if(head.getPrevious() == null && head.getNext() != null){
                buckets[index] = head.getNext();
                head.getNext().setPrevious(null);
            }
            else if(head.getPrevious() != null && head.getNext() == null){
                head.getPrevious().setNext(null);
            }
            else{
                buckets[index] = null;
            }
            this.size--;
            return head.getValue();
        }
        //We didnt find a match, meaning we just have to append it to the end by creating a new entry
        else{
            return null;
        }
    }

    public boolean containsKey(K key) {
        //Traverse the bucket
        int index = this.getIndex(key, this.buckets);
        MapEntry<K,V> head = this.traverseBucket(buckets[index], key);

        return head != null;
    }

    public int size() {
        // Return number of entries
        return this.size;
    }

    public int getCapacity(){
        return buckets.length;
    }

    public boolean isEmpty() {
        // Check if no entries
        return this.size == 0;
    }

    public void clear() {
        for(int j = 0; j < buckets.length; j++){
            buckets[j] = null;
        }
        this.size = 0;
    }

    //Internal use only
    private int getIndex(K key, MapEntry<K,V>[] buckets){
        //Index for the bucket, use 0 if key is null, power of 2 capacity allows bitwise operation instead of modulo for efficiency
        //Fixed 0 for null keys, null values dont matter
        return (key == null ? 0 : key.hashCode()) & (buckets.length - 1);
    }

    private MapEntry<K,V> traverseBucket(MapEntry<K,V> head, K key){
        MapEntry<K,V> pointer = head;
        while(pointer != null){ //Loop through until the end or until we find a match
            //Current entry matches
            if (pointer.key == key || (pointer.key != null && pointer.key.equals(key))) {
                return pointer;
            }

            //Keep traversing until we either reach the end or have a matching key
            pointer = pointer.getNext();
        }

        return null;
    }

    private void resize(){
        int oldCapacity = buckets.length;
        int newCapacity = oldCapacity << 1; //shift the bit one to the left, same as * 2
        MapEntry<K,V>[] newBucket = new MapEntry[newCapacity]; //Create the new bucket

        //Move entries from old bucket to new bucket
        for(int k = 0; k < oldCapacity; k++){
            //Move this chain to the appropriate index
            MapEntry<K,V> entry = buckets[k];

            //Traverse the chain
            while(entry != null){
                //Safe the next entry before doing the logic
                MapEntry<K,V> next = entry.getNext();
                int index = this.getIndex(entry.key, newBucket);

                //Add to the new chain, first handle previous
                if(newBucket[index] != null){
                    entry.setPrevious(null); //new head so null is previous
                    newBucket[index].setPrevious(entry);
                }
                //move the current entry to the front
                entry.setNext(newBucket[index]);
                newBucket[index] = entry;

                //Update the pointer
                entry = next;
            }
        }

        //Update the bucket to be the new one
        this.buckets = newBucket;

        //Update the threshold
        this.threshold = (int) (newCapacity * LOAD_FACTOR);
    }

    /**
     * MapEntry structure for the hashmap class
     */
    private static class MapEntry<K,V>{
        private final K key;
        private V value;
        private MapEntry<K,V> next;
        private MapEntry<K,V> previous;

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

        public MapEntry<K,V> getPrevious(){
            return this.previous;
        }

        public void setPrevious(MapEntry<K, V> previous){
            this.previous = previous;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapEntry<?, ?> that = (MapEntry<?, ?>) o;
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
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
