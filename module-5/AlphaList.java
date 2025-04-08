// Keanu Foltz module 5
//


import java.io.File;
import java.util.*;

public class AlphaList {
    public static void main(String[] args) {
        File file = new File("collection_of_words.txt");
        Scanner scan;
        HashSet<String> wordSet = new HashSet<>();
        ArrayList<String> arrayListWords = new ArrayList<>();

        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine().trim().toLowerCase();
                wordSet.add(line);



            }
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        arrayListWords.addAll(wordSet);
        Collections.sort(arrayListWords);
        System.out.println(arrayListWords);

        System.out.println();

        Collections.reverse(arrayListWords);
        System.out.println(arrayListWords);
    }
}