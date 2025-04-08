/*
 * Keanu Foltz Module 3 4/6/25
 * Removes duplicate values from an ArrayList of random integers
 */
package com.example.module3;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class RemoveDuplicatesProg {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
    
    public static void main(String[] args){
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 50; i++){
            originalList.add(random.nextInt(20) + 1);
        }
        
        System.out.println("original: ");
        System.out.println(originalList);
        
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);
        
        System.out.println("no duplicates: ");
        System.out.println(noDuplicates);
    }
}
