package dk.easv.dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoryData {
    private List<String> history;
    private final String historyFilePath = "C:\\Users\\Jakob\\Documents\\Computer Science\\SDE1\\Exercise 44.1 txt-files\\history.txt";

    public HistoryData() {
        history = new ArrayList<>();
    }

    public List<String> getHistory() {
        if(history.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(historyFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    history.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return history;
    }


    public void addHistory(String text) {
        try (FileWriter writer = new FileWriter(historyFilePath, true)) {
            writer.write("\n"+text);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
