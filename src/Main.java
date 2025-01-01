import dataStructures.*;
import sortingAlgorithms.SortingAlgorithms;

import java.security.PublicKey;
import java.util.SortedSet;

public class Main {

    public static String SEPARATOR = "-------------------";
    public static String RESULT = "Final:";
    public static String BUBBLESORT = "bubbleSort:";
    public static String INSERTSORT = "insertSort:";
    public static String SELECTIONSORT = "selectionSort:";
    public static String HEAPSORT = "heapSort:";
    public static String BUCKETSORT = "bucketSort:";
    public static String MERGESORT = "mergeSort:";
    public static String RADIXSORT = "radixSort:";

    public static void main(String[] args){
//        testPqueue();
        testSorting();
    }

    private static void testSorting(){
        Integer[] ints = {99, 32, 71, 45, 50};
        int[] intes = {14123, 32252, 71943, 45283, 50583};
        SortingAlgorithms<Integer> sortingAlgorithms = new SortingAlgorithms<>(ints);

        printMsg(INSERTSORT);
        sortingAlgorithms.insertSort();

        printMsg(BUBBLESORT);
        sortingAlgorithms.bubbleSort();

        printMsg(SELECTIONSORT);
        sortingAlgorithms.selectionSort();

        // se a arvore estiver toda estranha, mude o PRINTSPACE (de SortingAlgorithms) para um valor maior
        printMsg(HEAPSORT);
        sortingAlgorithms.heapSort();

//        printMsg(BUCKETSORT);
//        sortingAlgorithms.bucketSort(99, intes);

//        printMsg(RADIXSORT);
//        sortingAlgorithms.radixSort(5, intes);
    }

    private static void printMsg(String MSG){
        System.out.println(SEPARATOR+MSG);
    }

    private static void testPqueue(){
        MinHeap<Integer, Integer> pqueue = new MinHeap<>();

        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            pqueue.insert(i, i);
            System.out.println("Min:"+pqueue.minEntry().getKey());
        }
        System.out.println(SEPARATOR);
        pqueue.printArray();
        while (!pqueue.isEmpty())
            System.out.println(pqueue.removeMin().getKey());
        System.out.println(SEPARATOR);

        MaxHeap<Integer, Integer> maxpqueue = new MaxHeap<>();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            maxpqueue.insert(i, i);
            System.out.println("Max:"+maxpqueue.maxEntry().getKey());
        }
        System.out.println(SEPARATOR);
        maxpqueue.printArray();
        while (!maxpqueue.isEmpty())
            System.out.println(maxpqueue.removeMax().getKey());
        System.out.println(SEPARATOR);
    }

    private static void postArray(Integer[] integers){
        System.out.println(RESULT);
        for (int i : integers) System.out.print(i+" ");
        System.out.println();
    }



}
