/*
 * Keanu Foltz 3/30/25
 * This writes the data of random integers into a file
 */
package com.example.module2project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteFile {
    private static final String FILE_NAME = "keanudatafile.dat";
    
    public static void main(String[] args){
        Random random = new Random();
        File file = new File(FILE_NAME);
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println("Data:");
            
            for (int i=0; i < 5; i++){
                writer.print(random.nextInt(100)+ " ");
            }
            writer.println();
            
            for (int i = 0; i < 5; i++){
                writer.print(random.nextDouble()*100+ " ");
            }
            writer.println("\n");
            
            System.out.println("Data has been written to file " + FILE_NAME);
            
        }catch (IOException e) {
            System.err.println("Error writing to file " + e.getMessage());
        }
    }
}
