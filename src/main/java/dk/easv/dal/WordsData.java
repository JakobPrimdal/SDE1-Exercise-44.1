package dk.easv.dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordsData {
    private List<String> words;
    private final String wordsPath = "\"C:\\Users\\Jakob\\Documents\\Computer Science\\SDE1\\Exercise 44.1 txt-files\\brit-a-z.txt\"";

    public WordsData(){
        words = new ArrayList<>();
    }

    public List<String> getWords(){
        if(words.isEmpty())
        {
            try (BufferedReader br = new BufferedReader(new FileReader(wordsPath))){
                String line;
                while ((line = br.readLine()) != null){
                    words.add(line);
                }
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return words;
    }


}
