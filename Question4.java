package com.jenkov.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question4 extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Pane pane = new VBox(15);


        // Create a scene and place it in the stage
        Button button = new Button("View");
        button.setAlignment(Pos.BOTTOM_RIGHT);

        TextField txt = new TextField("Enter File Location");
        txt.setAlignment(Pos.BOTTOM_LEFT);

	//Only runs when the user presses the view button
        button.setOnAction(actionEvent -> {
            String fileName = txt.getText();
            createBar(fileName,pane);
        });

        pane.getChildren().addAll(button,txt);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Question 4"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void createBar(String fileName, Pane pane)
    {
        Scanner input = null;
        java.io.File file = new java.io.File(fileName);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); //If the file does not exist than it prints out file not found
        }
        int[] list = new int[26]; //Creates an int array of size 26
        String[] letterList = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
                "T","U","V","W","X","Y","Z"}; //Array of the entire alphabet
        while(input.hasNext())
        {
            String word = input.next();
	    //This for loop checks each letter and adds a value to the occurences list
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == 'A' || word.charAt(i) == 'a')
                    list[0]++;
                if(word.charAt(i) == 'B' || word.charAt(i) == 'b')
                    list[1]++;
                if(word.charAt(i) == 'C' || word.charAt(i) == 'c')
                    list[2]++;
                if(word.charAt(i) == 'D' || word.charAt(i) == 'd')
                    list[3]++;
                if(word.charAt(i) == 'E' || word.charAt(i) == 'e')
                    list[4]++;
                if(word.charAt(i) == 'F' || word.charAt(i) == 'f')
                    list[5]++;
                if(word.charAt(i) == 'G' || word.charAt(i) == 'g')
                    list[6]++;
                if(word.charAt(i) == 'H' || word.charAt(i) == 'h')
                    list[7]++;
                if(word.charAt(i) == 'I' || word.charAt(i) == 'i')
                    list[8]++;
                if(word.charAt(i) == 'J' || word.charAt(i) == 'j')
                    list[9]++;
                if(word.charAt(i) == 'K' || word.charAt(i) == 'k')
                    list[10]++;
                if(word.charAt(i) == 'L' || word.charAt(i) == 'l')
                    list[11]++;
                if(word.charAt(i) == 'M' || word.charAt(i) == 'm')
                    list[12]++;
                if(word.charAt(i) == 'N' || word.charAt(i) == 'n')
                    list[13]++;
                if(word.charAt(i) == 'O' || word.charAt(i) == 'o')
                    list[14]++;
                if(word.charAt(i) == 'P' || word.charAt(i) == 'p')
                    list[15]++;
                if(word.charAt(i) == 'Q' || word.charAt(i) == 'q')
                    list[16]++;
                if(word.charAt(i) == 'R' || word.charAt(i) == 'r')
                    list[17]++;
                if(word.charAt(i) == 'S' || word.charAt(i) == 's')
                    list[18]++;
                if(word.charAt(i) == 'T' || word.charAt(i) == 't')
                    list[19]++;
                if(word.charAt(i) == 'U' || word.charAt(i) == 'u')
                    list[20]++;
                if(word.charAt(i) == 'V' || word.charAt(i) == 'v')
                    list[21]++;
                if(word.charAt(i) == 'W' || word.charAt(i) == 'w')
                    list[22]++;
                if(word.charAt(i) == 'X' || word.charAt(i) == 'x')
                    list[23]++;
                if(word.charAt(i) == 'Y' || word.charAt(i) == 'y')
                    list[24]++;
                if(word.charAt(i) == 'Z' || word.charAt(i) == 'z')
                    list[25]++;
            }
        }
        CategoryAxis letters = new CategoryAxis(); //This is the x-axis
        NumberAxis occurrences = new NumberAxis(); //This is the y-axis
        BarChart<String,Number> barChart = new BarChart<>(letters,occurrences);
        XYChart.Series series = new XYChart.Series();
        for(int i = 0; i < list.length; i++)
            series.getData().add(new XYChart.Data(letterList[i],list[i]));
        barChart.getData().addAll(series);
        pane.getChildren().add(barChart); //adds the bar graph to the pane
    }
}