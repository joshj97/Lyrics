import java.util.*;
import java.io.*;

public class Song{

    private static HashMap<String, Integer> frequency = new HashMap<>();

    /*This function is to add the data into the HashMap data structure
    convert the words to upper case to remove case sensitivity,
    then replace all spaces with ',' and then split by ','
    If word exists within the Hashmap, then increase the count or add it to the map

    By using a Hashmap, data is stored within key-value pairs, It uses hashing to store the data,
    Since there can be no duplicate key in a Hashmap function we can use this to assign each word a key
    and increment in order to keep track of the words. That is why Hashmap is the best data structure for this project.
    */

    public static void countTheWords(String lyrics){


        String[] words = lyrics.toUpperCase().replace(" ", ",").trim().split(",");
        for(String word : words){
            Integer n = frequency.get(word);
            n = (n == null) ? 1 : ++n;
            frequency.put(word, n);
        }
        frequency.remove("");
    }

    //print the map
    public static void printTheWords(){
        for(Map.Entry<String, Integer> entry : frequency.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args){

        File file = new File("/Users/josh/IdeaProjects/SongLyrics/src/lyrics");
        try{
            Scanner sc = new Scanner(file);
            String lyrics;
            while(sc.hasNextLine()){
                lyrics = sc.nextLine();
                countTheWords(lyrics);
            }
            printTheWords();
        }
        catch(FileNotFoundException E){
            System.out.println("File not found");
        }
    }
}

