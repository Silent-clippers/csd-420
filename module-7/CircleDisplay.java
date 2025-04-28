// Keanu Foltz module 7.2 4/26/25
// displays 4 circles styled with css
package com.example.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class CircleDisplay extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Circle circle1 = new Circle(50, 50, 50);
        Circle circle2 = new Circle(50, 50, 50);
        Circle circle3 = new Circle(50, 50, 50);
        Circle circle4 = new Circle(50, 50, 50);
        TilePane tilePane = new TilePane();
        tilePane.setPadding(new Insets(0,5,0,5));
        tilePane.setHgap(5);
        tilePane.setVgap(5);
        tilePane.setPrefColumns(2);
        tilePane.getChildren().addAll(circle1, circle2, circle3, circle4);
        Scene scene = new Scene(new HBox(tilePane), 320, 240);
        scene.getStylesheets().add("stylesheet.css");
        circle1.getStyleClass().add("plainCircle");
        circle2.setId("green");
        circle3.setId("red");
        stage.setTitle("Circle Display");
        stage.setScene(scene);
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}