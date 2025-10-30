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
    private ListView lstviewHistory;
    @FXML
    private Label lblWordCount;
    @FXML
    private Label lblSearchResult;
    @FXML
    private RadioButton rBtnWholeWords;
    @FXML
    private RadioButton rBtnPartOfWorld;

    private WordsLogic wordsLogic = new WordsLogic();
    private SearchLogic searchLogic = new SearchLogic();


    @FXML
    private void onBtnSearch(ActionEvent actionEvent) {
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

        if (txtField.getText().isEmpty()) {
            populateLstviewWords();
        }
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
        populateLstviewWords();
    }

    @FXML
    private void radioBtnWholeWords(ActionEvent actionEvent) {
        rBtnPartOfWorld.setSelected(false);
    }

    @FXML
    private void radioBtnPartOfWord(ActionEvent actionEvent) {
        rBtnWholeWords.setSelected(false);
    }

    private void populateLstviewWords(){
        // Removes items in lstviewWords
        for(int i = 0; i < lstviewWords.getItems().size(); i++){
            lstviewWords.getItems().remove(i);
        }
        // Adds items to lstviewWords
        for(String w : wordsLogic.getWords()){
            lstviewWords.getItems().add(w);
        }
        lblWordCount.setText(String.valueOf(lstviewWords.getItems().size()));
    }
}
