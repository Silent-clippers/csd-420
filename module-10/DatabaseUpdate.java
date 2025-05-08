//Keanu Foltz module 10
//Allows for first names, last names, and favorite teams from a db to be displayed and updated

package com.example.module10dbs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DatabaseUpdate extends Application {
    Connection con;
    Button updateBtn = new Button("Update");
    Button displayBtn = new Button("Display");
    Label firstLbl = new Label("First Name");
    Label lastLbl = new Label("Last Label");
    Label favoriteLbl = new Label("Favorite Team");
    Label idLbl = new Label("ID");
    TextField id = new TextField("Enter ID");
    TextField firstName = new TextField();
    TextField lastName = new TextField();
    TextField favoriteTeam = new TextField();
    Stage parentStage;
    @Override
    public void start(Stage stage) throws IOException {
        parentStage = stage;
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.addRow(0, firstLbl);
        gridPane.addColumn(1, lastLbl);
        gridPane.addColumn(2, favoriteLbl);
        gridPane.addRow(1, firstName);
        gridPane.addColumn(1, lastName);
        gridPane.addColumn(2, favoriteTeam);
        gridPane.addRow(2, idLbl);
        gridPane.addRow(3, id);
        gridPane.add(displayBtn,1,3);
        gridPane.add(updateBtn,2,3);
        EventHandler<ActionEvent> displayEvent = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                displayData();
            }
        };
        EventHandler<ActionEvent> updateEvent = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                updateData();
            }
        };

        displayBtn.setOnAction(displayEvent);
        updateBtn.setOnAction(updateEvent);
        Scene scene = new Scene(gridPane, 320, 240);
        stage.setTitle("Database Display");
        stage.setScene(scene);
        stage.show();

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb?";

            con = DriverManager.getConnection(url + "user=student1&password=pass");

            System.out.println("Connection established - now executing a select");
        }
        catch (java.lang.Exception ex){

            ex.printStackTrace();
        }
    }
    public void displayData(){
        Statement stmt = null;
        int idValue = 0;
        try{
             idValue = Integer.parseInt(id.getText());
        } catch(NumberFormatException e){
            Stage dialog = new Stage();
            VBox vBox = new VBox();
            Label text = new Label("Please input a valid ID.");
            Button closeBtn = new Button("close");
            closeBtn.setOnAction(actionEvent -> {dialog.close();});
            vBox.getChildren().addAll(text,closeBtn);
            Scene dialogScene = new Scene(vBox,200,200);
            dialog.setScene(dialogScene);
            dialog.initOwner(parentStage);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
        }

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fans WHERE id= '" + idValue + "'");
            if(!rs.isBeforeFirst()){
                Stage dialog = new Stage();
                VBox vBox = new VBox();
                Label text = new Label("No such ID.");
                Button closeBtn = new Button("close");
                closeBtn.setOnAction(actionEvent -> {dialog.close();});
                vBox.getChildren().addAll(text,closeBtn);
                Scene dialogScene = new Scene(vBox,200,200);
                dialog.setScene(dialogScene);
                dialog.initOwner(parentStage);
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.showAndWait();
            }else{
                rs.next();
                firstName.setText(rs.getString(2));
                lastName.setText(rs.getString(3));
                favoriteTeam.setText(rs.getString(4));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateData(){
        Statement stmt = null;
        int idValue = 0;
        try{
            idValue = Integer.parseInt(id.getText());
        } catch(NumberFormatException e){
            Stage dialog = new Stage();
            VBox vBox = new VBox();
            Label text = new Label("Please input a valid ID.");
            Button closeBtn = new Button("close");
            closeBtn.setOnAction(actionEvent -> {dialog.close();});
            vBox.getChildren().addAll(text,closeBtn);
            Scene dialogScene = new Scene(vBox,200,200);
            dialog.setScene(dialogScene);
            dialog.initOwner(parentStage);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
        }
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fans WHERE id= '" + idValue + "'");
            if(!rs.isBeforeFirst()){
                stmt.executeUpdate("INSERT INTO fans VALUES("+ id.getText() + ",'" + firstName.getText() + "','" + lastName.getText() + "','" + favoriteTeam.getText() + "')");
            }else{
                stmt.executeUpdate("UPDATE fans SET firstname = '" + firstName.getText() +"', lastname = '" + lastName.getText() +"', favoriteteam = '" + favoriteTeam.getText() +"' WHERE id = " + id.getText() + ";");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() throws Exception {
        con.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}