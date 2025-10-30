package dk.easv.gui;

import dk.easv.bll.SearchLogic;
import dk.easv.bll.WordsLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloViewController implements Initializable {

    @FXML
    private TextField txtField;
    @FXML
    private ListView lstviewAwords;
    @FXML
    private ListView lstviewWords;
    @FXML
    private ListView lstviewNwords;
    @FXML
    private ListView lstviewHistory; // History is not implemented yet
    @FXML
    private Label lblWordCount;
    @FXML
    private Label lblSearchResult;
    @FXML
    private RadioButton rBtnWholeWords;
    @FXML
    private RadioButton rBtnPartOfWorld;

    private List<String> words = new ArrayList<>();

    private WordsLogic wordsLogic = new WordsLogic();
    private SearchLogic searchLogic = new SearchLogic();

    private boolean updateLstview = false;


    @FXML
    private void onBtnSearch(ActionEvent actionEvent) {
        if (updateLstview)
            updateLstviewWords();

        if (rBtnWholeWords.isSelected() && !rBtnPartOfWorld.isSelected()){
            if (!txtField.getText().isEmpty()) {
                searchLogic.getFilteredWords(txtField.getText().toLowerCase(), lstviewWords);
                lblWordCount.setText(String.valueOf(lstviewWords.getItems().size()));

            }
            if(!lstviewWords.getItems().isEmpty()) {
                lblSearchResult.setText("'"+txtField.getText()+"' was found "+lstviewWords.getItems().size()+" time(s).");
            } else {lblSearchResult.setText("'"+txtField.getText()+"' was not found");}

        }

        if (rBtnPartOfWorld.isSelected() && !rBtnWholeWords.isSelected()){
            if(!txtField.getText().isEmpty()) {
                searchLogic.getWordsContainingFilter(txtField.getText().toLowerCase(), lstviewWords);
                lblWordCount.setText(String.valueOf(lstviewWords.getItems().size()));
            }
            if(!lstviewWords.getItems().isEmpty()) {
                lblSearchResult.setText("'"+txtField.getText()+"' was found "+lstviewWords.getItems().size()+" time(s).");
            } else {lblSearchResult.setText("'"+txtField.getText()+"' was not found");}

        }

        updateLstview = true;
    }

    @FXML
    private void onBtnSearchForA(ActionEvent actionEvent) {
        searchLogic.getFilteredWords('a', lstviewAwords);
    }

    @FXML
    private void onBtnSearchForN(ActionEvent actionEvent) {
        searchLogic.getFilteredWords('n', lstviewNwords);
    }

    @FXML
    private void onBtnClearHistory(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(String w : wordsLogic.getWords()){
            words.add(w);
            lstviewAwords.getItems().add(w);
            lstviewNwords.getItems().add(w);
            lstviewWords.getItems().add(w);
        }
    }

    @FXML
    private void radioBtnWholeWords(ActionEvent actionEvent) {
        rBtnPartOfWorld.setSelected(false);
    }

    @FXML
    private void radioBtnPartOfWord(ActionEvent actionEvent) {
        rBtnWholeWords.setSelected(false);
    }

    private void updateLstviewWords() {
        // Removes all current items in lstviewWords
            lstviewWords.getItems().clear();


        // Adds all orignal items to lstviewWords
        for(String w : words){
            lstviewWords.getItems().add(w);
        }
        lblWordCount.setText(String.valueOf(lstviewWords.getItems().size()));

    }

}
