/*
 * Keanu Foltz mod 4/6/25
 * Traverses linked list through iterator and get(index) and measures times 
 * and tests code to check that both traverse the same elements. In both cases the  
 * Iterator was significantly faster than the get(index) for each value, with the  
 * traversal over 500,000 elements taking exponentially longer with the get(index) 
 * (close to 3000x longer)
 */
package com.example.module4;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraverse {
    public static void main(String[] args){
        Traversal(50000);
        Traversal(500000);
    }
    
    private static void Traversal(int size){
        System.out.println();
        System.out.println("Size: " + size);
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++){
            list.add(i);
    }
    
    
    long startTime = System.currentTimeMillis();
    long sumIterator = 0;
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()){
        sumIterator += iterator.next();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Iterator:" + (endTime - startTime) + " millis");
    
    
    startTime = System.currentTimeMillis();
    long sumGet = 0;
    for (int i = 0; i < list.size(); i++){
        sumGet += list.get(i);
    }
    endTime = System.currentTimeMillis();
    System.out.println("get(index): " + (endTime - startTime) + " millis");
    
    System.out.println("Traversal verify: " + (sumIterator == sumGet));
}
    
}
