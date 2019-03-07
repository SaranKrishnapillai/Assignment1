package com.jenkov.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Question2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        GridPane pane = new GridPane();

        Label lb1 = new Label("Investment Amount");
        Label lb2 = new Label("Years");
        Label lb3 = new Label("Annual Interest Rate");
        Label lb4 = new Label("Future Value");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        tf4.setEditable(false); //makes the 4th text field uneditable
        tf1.setAlignment(Pos.BASELINE_RIGHT);
        tf2.setAlignment(Pos.BASELINE_RIGHT);
        tf3.setAlignment(Pos.BASELINE_RIGHT);
        tf4.setAlignment(Pos.BASELINE_RIGHT);

        Button button = new Button("Calculate");

        pane.add(lb1,0,0);
        pane.add(lb2,0,2);
        pane.add(lb3,0,4);
        pane.add(lb4,0,6);

        pane.add(tf1,2,0);
        pane.add(tf2,2,2);
        pane.add(tf3,2,4);
        pane.add(tf4,2,6);

        pane.add(button,2,7);
	//This section of the code only runs when the button Calculate is pressed
        button.setOnAction(actionEvent -> {
                double investAmount = Double.parseDouble(tf1.getText());
                double years = Double.parseDouble(tf2.getText());
                double interestRate = Double.parseDouble(tf3.getText());
                double value = investAmount*(1+interestRate/100*years); // Uses the formula to calculate Future Value
                DecimalFormat f = new DecimalFormat("##.00"); //Rounds to two decimal places
                tf4.setText("" + f.format(value));            
});
        Scene scene = new Scene(pane, 300, 200);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Question 2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
