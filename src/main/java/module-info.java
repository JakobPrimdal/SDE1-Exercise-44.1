module dk.easv.exercise_441 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.exercise_441 to javafx.fxml;
    exports dk.easv.exercise_441;
    exports dk.easv.exercise_441.gui;
    opens dk.easv.exercise_441.gui to javafx.fxml;
}