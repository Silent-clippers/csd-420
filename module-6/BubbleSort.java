// Keanu Foltz Module 6 4/20/25
// Sorts list of Integers using Comparable and Comparator interfaces

import java.util.Comparator;

public class BubbleSort {
    public static void main(String[]args){
        Integer [] list = {4,45,52,12,67,7,2,9,10,34};
        System.out.println("Unsorted:");
        printArrayInline(list);
        System.out.println("Comparable: ");
        bubbleSort(list);
        System.out.println("Comparator:");
        bubbleSort(list, Comparator.naturalOrder());

    }

    public static <E extends Comparable<E>> void bubbleSort(E[]list) {
        boolean unsorted = true;
        while(unsorted){
            unsorted = false;
            for(int i=0; i < list.length - 1; i++){
                E a = list[i];
                E b = list[i+1];
                if(a.compareTo(b) == 1){
                    list[i] = b;
                    list[i+1] = a;
                    unsorted = true;
                }
            }
        }
        printArrayInline(list);
    }
    public static <E>void bubbleSort(E[] list, Comparator<?super E> comparator){
        boolean unsorted = true;
        while(unsorted) {
            unsorted = false;
            for (int i = 0; i < list.length - 1; i++) {
                E a = list[i];
                E b = list[i + 1];
                if (comparator.compare(a, b) == 1) {
                    list[i] = b;
                    list[i + 1] = a;
                    unsorted = true;
                }
            }
        }
        printArrayInline(list);
    }
    public static <E> void printArray(E[] array){
        for(int i = 0; i < array.length;i++){
            System.out.println(array[i].toString());
        }
    }
    public static <E> void printArrayInline(E[] array){
        for(int i = 0; i < array.length-1;i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length-1]);
    }
}
