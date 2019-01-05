package com.mk.grocerylist;

import com.mk.grocerylist.datamodel.groceryListItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private List<groceryListItem> groceries;
    @FXML
    private ListView groceriesList;
    @FXML
    private Button addToList;
    @FXML
    private TextField textField;
    @FXML
    private Button deleteSelected;
    @FXML
    private MenuItem saveGroceryListToFile;
    String line = null;

    public void initialize() throws IOException {
        groceries = new ArrayList<groceryListItem>();
        groceriesList.getItems().setAll(groceries);
        loadGroceriesFromFile();

    }

    @FXML
    public void deleteAll() throws FileNotFoundException {
        groceries.clear();
        groceriesList.getItems().setAll(groceries);
        saveGroceryListToFile();

    }


    @FXML
    public void addToList() throws FileNotFoundException {
        groceryListItem item = new groceryListItem(textField.getText());
        groceries.add(item);
        groceriesList.getItems().setAll(groceries);
        textField.setText("");
        saveGroceryListToFile();
        groceriesList.getSelectionModel().select(groceries.size()-1);
    }

    @FXML
    public void deleteSelected() throws FileNotFoundException {
        int toDeleteIndex = groceriesList.getSelectionModel().getSelectedIndex();
        groceriesList.getItems().remove(toDeleteIndex);
        groceries.remove(toDeleteIndex);
        saveGroceryListToFile();
        groceriesList.getItems().setAll(groceries);
        if (toDeleteIndex==0) {
            groceriesList.getSelectionModel().select(toDeleteIndex);
        } else {
            groceriesList.getSelectionModel().select(toDeleteIndex - 1);
        }
    }


    @FXML
    public void saveGroceryListToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("grocery list.txt"));
        pw.println(groceries);
        pw.close();
        textField.requestFocus();
    }

    @FXML

    public void loadGroceriesFromFile() throws IOException {
        groceries = FXCollections.observableArrayList();
        Path path = Paths.get("grocery list.txt");
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        String input;
        int i = 0;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                input=input.replace("[","");
                input=input.replace("]","");
                String[] itemPieces = input.split(", ");

                int j = itemPieces.length;
                for (i=0;i<j;i=i+1 ) {


                    groceryListItem item = new groceryListItem(itemPieces[i]);
                    System.out.println(itemPieces[i]);
                    groceries.add(item);
                }
                if (itemPieces[0].equals("")) {
                    groceries.remove(0);
                }
                groceriesList.getItems().setAll(groceries);
                groceriesList.getSelectionModel().select(0);
                textField.requestFocus();

            }

            } finally {
            if(bufferedReader!=null){
                bufferedReader.close();
                }
            }
        }

    }




