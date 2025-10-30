package dk.easv.bll;

import dk.easv.dal.WordsData;
import javafx.scene.control.ListView;

import java.util.List;

public class SearchLogic {

    private WordsData data = new WordsData();

    /**
     * Adds words that start with char filter to the ListView
     * @param filter
     * @param lstview
     */
    public void getFilteredWords(char filter, ListView lstview) {
        for(String w : data.getWords()){
            char c = w.charAt(0);
            if(c != filter){
                lstview.getItems().remove(w);
            }
        }
    }

    /**
     * Removes words that doesn't match String filter from the ListView
     * @param filter
     * @param lstview
     */
    public void getFilteredWords(String filter, ListView lstview) {
        for(String w : data.getWords()){
            if(!w.equals(filter)){
                lstview.getItems().remove(w);
            }
        }
    }

    /**
     * Removes words that doesn't contain String filter from the ListView
     * @param filter
     * @param lstview
     */
    public void getWordsContainingFilter(String filter, ListView lstview) {
        for(String w : data.getWords()){
            if(!w.contains(filter)){
                lstview.getItems().remove(w);
            }
        }
    }
}
