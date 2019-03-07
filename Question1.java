package com.jenkov.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Question1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new HBox(15);

        int[] randomInts = new int[3];
        for(int i = 0; i < 3; i++)
        {
            randomInts[i] = randomNum();
        }

        ImageView img = new ImageView("" + randomInts[0] + ".png"); //gets a random picture
        ImageView img2 = new ImageView("" + randomInts[1] + ".png");
        ImageView img3 = new ImageView("" + randomInts[2] + ".png");
        pane.getChildren().addAll(img,img2,img3);


        Scene scene = new Scene(pane, 250, 125);
        primaryStage.setTitle("Question 1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    //This method return a random interger from 1-52
    public int randomNum()
    {
        Random rand = new Random();
        int n = rand.nextInt(52)+1;
        return n;
    }
}
