package com.jenkov.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Question3 extends Application {
    private double radius = 10;
    private Circle[] points = {new Circle(5), new Circle(5), new Circle(5)};
    private Circle circle = new Circle(200,200,75);
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private Text[] text = {new Text(), new Text(), new Text()};

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Random rand = new Random();
        for(int i = 0; i < points.length; i++)
        {
            points[i].setStroke(Color.BLACK);
            points[i].setFill(Color.RED);
            int x = rand.nextInt(76); //random int from 0-75 (75 is the radius of the circle)
            int y = (int) Math.sqrt(75*75-x*x); //uses the equation r^2 = x^2 + y^2 to get the y value
            System.out.println(x + " " + y);
            if(i==0) {
                points[i].setCenterX(x+200);
                points[i].setCenterY(200-y);
            }
            if(i==1){
                points[i].setCenterX(200-x);
                points[i].setCenterY(200+y);
            }
            if(i==2){
                points[i].setCenterX(x+200);
                points[i].setCenterY(y+200);
            }

        }
        circle.setStroke(Color.BLACK); //Sets the edge of the circle to black
        circle.setFill(Color.WHITE); //Sets the inside of the circle to white
        Pane pane = new Pane();
        setLines();
        pane.getChildren().addAll(circle,points[0], points[1], points[2],
                line1, line2, line3, text[0], text[1], text[2]);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Question 3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
	//This section of code allowes the user to move a point on the circle
        points[0].setOnMouseDragged(e -> {
            if (points[0].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[0].setCenterX(e.getX());
                points[0].setCenterY(e.getY());
                setLines();
            }
        });

        points[1].setOnMouseDragged(e -> {
            if (points[1].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[1].setCenterX(e.getX());
                points[1].setCenterY(e.getY());
                setLines();
            }
        });

        points[2].setOnMouseDragged(e -> {
            if (points[2].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[2].setCenterX(e.getX());
                points[2].setCenterY(e.getY());
                setLines();
            }
        });
    }

    private void setLines() {
        //This moves the lines so that they stay connected to the points on the circle
        line1.setStartX(points[0].getCenterX());
        line1.setStartY(points[0].getCenterY());
        line1.setEndX(points[1].getCenterX());
        line1.setEndY(points[1].getCenterY());
        line2.setStartX(points[0].getCenterX());
        line2.setStartY(points[0].getCenterY());
        line2.setEndX(points[2].getCenterX());
        line2.setEndY(points[2].getCenterY());
        line3.setStartX(points[1].getCenterX());
        line3.setStartY(points[1].getCenterY());
        line3.setEndX(points[2].getCenterX());
        line3.setEndY(points[2].getCenterY());

        // Compute angles
        double a = new Point2D(points[2].getCenterX(), points[2].getCenterY()).
                distance(points[1].getCenterX(), points[1].getCenterY());
        double b = new Point2D(points[2].getCenterX(), points[2].getCenterY()).
                distance(points[0].getCenterX(), points[0].getCenterY());
        double c = new Point2D(points[1].getCenterX(), points[1].getCenterY()).
                distance(points[0].getCenterX(), points[0].getCenterY());
        double[] angle = new double[3];
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c)); //Calculates the angle between two lines
        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        for (int i = 0; i < 3; i++) {
            text[i].setX(points[i].getCenterX());
            text[i].setY(points[i].getCenterY() - radius);
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
	    //Angles are in radians so they have to be converted
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
