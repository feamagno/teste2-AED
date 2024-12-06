package dataStructures;
import dataStructures.exceptions.*;

public interface MaxPriorityQueue<K extends Comparable<K>, V> {
    // Returns true iff the priority queue contains no
    //    entries.
    boolean isEmpty( );
    // Returns the number of entries in the priority queue.
    int size( );

    // Returns an entry with the smallest key in the priority
    // queue.
    Entry<K,V> maxEntry( ) throws EmptyPriorityQueueException;

    // Inserts the entry (key, value) in the priority queue.
    void insert( K key, V value );
    // Removes an entry with the smallest key from the
    // priority
    // queue and returns that entry.
    Entry<K,V> removeMax( ) throws
            EmptyPriorityQueueException;

    Entry<K,V>[] heapSort();
    // End of dataStructures.MinPriorityQueue.
}
