package com.mk.grocerylist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {
TextField textField = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Grocery List");
        primaryStage.setScene(new Scene(root, 355, 500));
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        textField.isFocused();
    }

    @Override
    public void stop() throws Exception {

    }

    public static void main(String[] args) {
        launch(args);

    }
}
