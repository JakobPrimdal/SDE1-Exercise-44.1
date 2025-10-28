package dk.easv.gui;

import dk.easv.bll.WordsLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloViewController {

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

    private WordsLogic wordsLogic = new WordsLogic();

    @FXML
    private void onBtnSearch(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnSearchForA(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnSearchForN(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnClearHistory(ActionEvent actionEvent) {
    }
}
