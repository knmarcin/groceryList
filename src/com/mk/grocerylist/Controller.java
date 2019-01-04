package com.mk.grocerylist;

import com.mk.grocerylist.datamodel.groceryListItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

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

    public void initialize() {

        groceries = new ArrayList<groceryListItem>();
        groceriesList.getItems().setAll(groceries);

    }
    @FXML
    public void addToList() {
        groceryListItem item = new groceryListItem(textField.getText());
        groceries.add(item);
        groceriesList.getItems().setAll(groceries);
    }

    @FXML
    public void deleteSelected() {

        int toDeleteIndex = groceriesList.getSelectionModel().getSelectedIndex();
        groceriesList.getItems().remove(toDeleteIndex);
        groceries.remove(toDeleteIndex);
        groceriesList.getItems().setAll(groceries);
        System.out.println(groceries);


    }




}
