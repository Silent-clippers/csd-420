/*
 * keanu foltz module 2 3/30/25 
 * this program reads the files
 */
package com.example.module2project;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private static final String FILE_NAME = "keanudatafile.dat";
    
    public static void main(String[] args){
        File file = new File(FILE_NAME);
        
        if (!file.exists()){
            System.out.println("No File Found");
            return;
        }
        try(Scanner scanner = new Scanner(file)) {
            System.out.println("File: " + FILE_NAME + ":");
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error");
        }
            
    }
    
}
