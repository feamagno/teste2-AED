package sortingAlgorithms;

import dataStructures.*;

import java.util.LinkedList;

public class SortingAlgorithms<E extends Comparable<E>> {

    public static String SEPARATOR = "-------------------";

    E[] unsortedArray;

    public SortingAlgorithms(E[] unsortedArray){
        this.unsortedArray = unsortedArray;
    }

    public void insertSort(){
        E[] array = copyArray();

        for (int i = 1; i < array.length; i++) {
            postArray(array);
            E valueAtI = array[i];
            int j = i;
            while (j > 0 && array[j-1].compareTo(valueAtI) > 0) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = valueAtI;
        }
        finalResult(array);
    }

    public void bubbleSort(){
        E[] array = copyArray();

        for (int i = array.length-1; i > 0; i--) {
            postArray(array);
            for (int j = 0; j < i; j++)
                if (array[j].compareTo(array[j + 1]) > 0) {
                    E tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
        }
        finalResult(array);
    }

    public void selectionSort(){
        E[] array = copyArray();
        for (int i = array.length-1; i > 0; i--) {
            postArray(array);
            int max = i;
            for (int j = i - 1; j >= 0; j--)
                if (array[max].compareTo(array[j]) < 0)
                    max = j;
            E value = array[i];
            array[i] = array[max];
            array[max] = value;
        }
        finalResult(array);
    }

    public void heapSort(){
        E[] unsorted = copyArray();
        int lastPos = unsorted.length;

        System.out.println(SEPARATOR + "Making array:");
        for (int i = (unsorted.length - 2)/2; i >= 0; i--) {
            printArray(unsorted.length, unsorted);
            percolateDown(i, unsorted, lastPos--);
        }
        printArray(unsorted.length, unsorted);

        System.out.println(SEPARATOR + "Sorting array:");
        for (int j = unsorted.length - 1; j > 0; j--){
            printArray(unsorted.length, unsorted);
            E e = unsorted[0];
            unsorted[0] = unsorted[j];
            unsorted[j] = e;
            percolateDown(0, unsorted, j-1);
        }
        printArray(unsorted.length, unsorted);
        finalResult(unsorted);
    }

    protected void percolateDown(int firstPos, E[] vec, int lastPos){
        E rootElement = vec[firstPos];
        int hole = firstPos;
        int child = hole * 2 + 1;
        while (child <= lastPos){
            if (child < lastPos && vec[child+1].compareTo(vec[child]) > 0)
                child++;
            if (vec[child].compareTo(rootElement) > 0){
                vec[hole] = vec[child];
                hole = child;
                child = hole * 2 + 1;
            }
            else break;
        }
        vec[hole] = rootElement;
    }

    @SuppressWarnings("unchecked")
    public void bucketSort(int biggestKey, int[] array){
        LinkedList<Integer>[] linkedLists = new LinkedList[biggestKey+1];
        int[] newArray = new int[biggestKey+1];

        for (int i : array) {
            LinkedList<Integer> linkedList = linkedLists[i];
            if (linkedList == null)
                linkedLists[i] = new LinkedList<>();
            linkedLists[i].addLast(i);
        }

        for (int i = 0; i < linkedLists.length; i ++){
            LinkedList<Integer> linkedList = linkedLists[i];
            if (linkedList != null)
                for (Integer j: linkedList)
                    newArray[j] = j;
        }
        finalResult(newArray);
    }

    private int MAX_INT = 10;

//    @SuppressWarnings("unchecked")
//    public void radixSort(int size, int[] array){
//        LinkedList<Integer>[] vec = (LinkedList<Integer>[]) new LinkedList[MAX_INT];
//        LinkedList<Integer>[] newArray;
//        int mask = 0;
//        for (int i = 0; i < size; i++) {
//            newArray = (LinkedList<Integer>[]) new LinkedList[MAX_INT];
//            for (int j = 0; j < array.length; j++) {
//                // masking
//                mask = array[j];
//                for (int k = 0; k <= i; k++) // pega a parte que vem depois do "caracter" q a gnt quer
//                    mask = mask/10;
//
//                mask = array[j] - 10*mask*(i+1);
//                // tira a parte da frente que a gente não quer
//
//                for (int m = 0; m < i; m++)
//                    mask = mask/10;
//
//                newArray[mask].addLast(array[j]);
//            }
//            vec = newArray;
//            postArray(array);
//        }
//        finalResult(array);
//    }

//    @SuppressWarnings("unchecked")

//        idfk they put it wrong on the slides

//    public void mergeSort(){
//        E[] array = copyArray();
//        E[] auxVec = (E[]) new Comparable[array.length];
//        mergeSortR(array, auxVec, 0, array.length - 1);
//        postArray(array);
//    }
//
//    protected void mergeSortR(E[] vec, E[] auxVec, int firstPos, int lastPos){
//        if (firstPos < lastPos){
//            int centre = (firstPos + lastPos) / 2;
//            mergeSortR(vec, auxVec, firstPos, centre);
//            mergeSortR(vec, auxVec, centre+1, lastPos);
//            System.out.println("antes:");
//            postArray(vec);
//            mergeR(vec, auxVec, firstPos, centre, lastPos);
//            System.out.println("depois:");
//            postArray(vec);
//        }
//    }
//
//    protected void mergeR(E[] vec, E[] auxVec, int firstLeft, int lastLeft, int lastRight){
//        int left = firstLeft;
//        int right = lastLeft + 1;
//        int result = firstLeft;
//        while (left <= lastLeft && right <= lastRight)
//            if (vec[left].compareTo(vec[right]) <= 0) {
//                auxVec[result] = vec[left];
//                result++;
//                left++;
//            }
//            else {
//                auxVec[result] = vec[right];
//                result++;
//                right++;
//            }
//        while (left <= lastLeft) {
//            auxVec[result] = auxVec[left];
//            result++;
//            left++;
//        }
//
//        System.arraycopy(auxVec, firstLeft, vec, firstLeft, result - firstLeft);
//    }

    protected void postArray(E[] array){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        for (E e : array) System.out.print(e+" ");
        System.out.println();
    }

    protected void finalResult(E[] array){
        postArray(array);
        System.out.println("Final:");
        postArray(array);
        System.out.println();
    }


    protected void postArray(int[] array){
        for (int i : array)
            if (i != 0)
                System.out.print(i+" ");
        System.out.println();
    }

    protected void finalResult(int[] array){
        System.out.println("Final:");
        postArray(array);
        System.out.println();
    }

    protected void postEntryArray(Entry<E,E>[] array){
        int i = 0;
        while (i < array.length && array[i] != null)
            System.out.print(array[i++].getKey()+" ");
        System.out.println();
    }

    protected void finalEntryResult(Entry<E,E>[] array){
        System.out.println("Final:");
        postEntryArray(array);
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    protected Entry<E,E>[] entryArray(E[] unsortedArray){
        Entry<E,E>[] array = (Entry<E,E>[]) new Entry[unsortedArray.length];
        int i = 0;
        for (E e: unsortedArray)
            array[i++] = new EntryClass<>(e, e);
        return array;
    }


    @SuppressWarnings("unchecked")
    protected E[] copyArray(){
        E[] array = (E[]) new Comparable[unsortedArray.length];
        System.arraycopy(unsortedArray,0,array,0,unsortedArray.length);
        return array;
    }

    public static int PRINTSPACE = 16;

    public void printArray(int currentSize, E[] array) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        int j = 0;
        for (int i = 0; i < getHeight(currentSize); i++) {
            int expo = 0;
            while (expo++ < exponencial(2, i) && j < currentSize) {
                printSpaces(i);
                System.out.print(array[j]);
                if (array[j] instanceof Integer)
                    printSpaces1(i, (Integer) array[j++]);
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
    }


    private void printSpaces1(int i, Integer j){
        int count = 1;
        while (j/10 > 0) {
            j = j/10;
            count++;
        }
        for (int k = 0; k < getSpaces(i)-count; k++)
            System.out.print(" ");
    }

    private void printSpaces(int i){
        for (int k = 0; k < getSpaces(i); k++)
            System.out.print(" ");
    }

    private int getSpaces(int i){
        if (i == 0) return PRINTSPACE;
        i *= 2;
        return PRINTSPACE/i;
    }

    private int exponencial(int base, int exp){
        if (exp == 0) return 1;
        while (exp-- > 1)
            base *= base;
        return base;
    }

    protected int getHeight(int currentSize){
        int count = 1;
        int hole = currentSize;
        int parent = (currentSize - 1) / 2;
        while (hole > 0){
            hole = parent;
            parent = (hole - 1) / 2;
            count++;
        }
        return count;
    }

}
