/**
 * Keanu Foltz module 1 3/23/25
 * displays 4 random cards out of the 54 available 
 */
package com.mycompany.randomcard;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class App extends Application {
    private static final String CARD_FOLDER = "C:\\csd\\csd-420\\module-1\\cards\\";
    private static final int TOTAL_CARDS = 54;
    private static final int CARDS_DISPLAYED = 4;

    private ImageView[] cardViews = new ImageView[CARDS_DISPLAYED];

    @Override
    public void start(Stage primaryStage) {
        HBox cardBox = new HBox(10);
    
        for (int i = 0; i < CARDS_DISPLAYED; i++){
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setPreserveRatio(true);
        }

        refreshCards();
        cardBox.getChildren().addAll(cardViews);
    
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshCards());
        
        VBox root = new VBox(10, cardBox, refreshButton);
        root.setStyle("-fx-padding: 30px; -fx-alignment: center");
        
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Cards Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void refreshCards() {
        Set<Integer> selectedCards = new HashSet<>();
        Random random = new Random();
        
        while (selectedCards.size() < CARDS_DISPLAYED) {
            int cardNumber = random.nextInt(TOTAL_CARDS) + 1;
            selectedCards.add(cardNumber);
        }
        
        int i = 0;
        for (int cardNumber : selectedCards) {
            File file = new File(CARD_FOLDER + cardNumber + ".png");
            if (file.exists()){
                cardViews[i].setImage(new Image(file.toURI().toString()));
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}



