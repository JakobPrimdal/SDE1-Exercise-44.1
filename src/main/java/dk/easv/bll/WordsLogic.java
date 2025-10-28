package dk.easv.bll;

import dk.easv.dal.WordsData;

import java.util.List;

public class WordsLogic {

    private WordsData data = new WordsData();

    public List<String> getWords()
    {
        return data.getWords();
    }


}
