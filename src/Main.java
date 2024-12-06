import dataStructures.*;

public class Main {

    public static String SEPARATOR = "-------------------";

    public static void main(String[] args){
        MinPriorityQueue<Integer, Integer> pqueue = new MinHeap<>();



        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            pqueue.insert(i, i);
            System.out.println("Min:"+pqueue.minEntry().getKey());
        }
        System.out.println(SEPARATOR);
        while (!pqueue.isEmpty())
            System.out.println(pqueue.removeMin().getKey());
    }
}
