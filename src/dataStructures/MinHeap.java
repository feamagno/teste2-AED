package dataStructures;

import dataStructures.exceptions.EmptyPriorityQueueException;

public class MinHeap<K extends Comparable<K>, V> implements MinPriorityQueue<K,V>{

    // Default capacity of the priority queue.
    public static final int DEFAULT_CAPACITY = 100;

    // The growth factor of the extendable array.
    public static final int GROWTH_FACTOR = 2;

    // Memory of the priority queue: an extendable array.
    protected Entry<K,V>[] array;

    // Number of entries in the priority queue.
    protected int currentSize;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity){
        array = (Entry<K,V>[]) new Entry[capacity];
        currentSize = 0;
    }

    public MinHeap(){
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(Entry<K,V>[] array){
        buildArray(array.length, array);
        currentSize = array.length;
        buildPriorityTree();
    }

    protected void buildPriorityTree(){
        for (int i = (currentSize - 1) / 2; i >= 0; i--)
            percolateDown(i);
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Returns true iff the array cannot contain more entries.
    protected boolean isFull( ){
        return currentSize == array.length;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Entry<K, V> minEntry() throws EmptyPriorityQueueException {
        if (isEmpty()) throw new EmptyPriorityQueueException();
        return array[0];
    }

    @Override
    public void insert(K key, V value) {
        if (isFull())
            buildArray(GROWTH_FACTOR*currentSize, array);

        int hole = percolateUp(currentSize, key);
        array[hole] = new EntryClass<>(key,value);
        currentSize++;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) throw new EmptyPriorityQueueException();

        Entry<K,V> minEntry = array[0];
        currentSize--;
        array[0] = array[currentSize];
        array[currentSize] = null;
        if (currentSize > 1)
            percolateDown(0);

        return minEntry;
    }

    protected int percolateUp(int hole, K key){
        int parent = (hole - 1) / 2;
        while (hole > 0 && key.compareTo(array[parent].getKey()) < 0){
            array[hole] = array[parent];
            hole = parent;
            parent = (hole - 1) / 2;
        }
        return hole;
    }

    protected void percolateDown(int firstPos){
        Entry<K,V> rootEntry = array[firstPos];
        K rootKey = rootEntry.getKey();
        int hole = firstPos;
        int child = hole * 2 + 1;
        boolean rootIsSmaller = true;
        while (child < currentSize && rootIsSmaller) {
            if (child < currentSize - 1 &&
                    array[child+1].getKey().compareTo(array[child].getKey()) < 0)
                child++;
            rootIsSmaller = array[child].getKey().compareTo(rootKey) < 0;
            if (rootIsSmaller) {
                array[hole] = array[child];
                hole = child;
                child = hole * 2 + 1;
            }
        }
        array[hole] = rootEntry;
    }

    @SuppressWarnings("unchecked")
    protected void buildArray(int capacity, Entry<K,V>[] contents){
        Entry<K,V>[] newArray = (Entry<K,V>[]) new Entry[capacity];
        System.arraycopy(contents,0,newArray,0,contents.length);
        array = newArray;
    }
}
