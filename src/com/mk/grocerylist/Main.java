package com.mk.grocerylist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Grocery List");
        primaryStage.setScene(new Scene(root, 303, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
