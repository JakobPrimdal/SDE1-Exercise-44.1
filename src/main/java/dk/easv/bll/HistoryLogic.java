package dk.easv.bll;

import dk.easv.dal.HistoryData;

import java.util.List;

public class HistoryLogic {

    private HistoryData historyData = new HistoryData();

    public List<String> getHistory() {return historyData.getHistory();}

    public void addHistory(String text) {historyData.addHistory(text);}

}
