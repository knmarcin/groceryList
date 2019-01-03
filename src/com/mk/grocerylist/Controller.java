package com.mk.grocerylist;

import com.mk.grocerylist.datamodel.groceryListItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<groceryListItem> groceries;
    @FXML
    private ListView groceriesList;
    @FXML
    private Button addToList;

    public void initialize() {
        groceryListItem item1 = new groceryListItem("Chleb");
        groceryListItem item2 = new groceryListItem("Szynka 200g");
        groceryListItem item3 = new groceryListItem("Ser kostka");
        groceryListItem item4 = new groceryListItem("Pieczarki 50g");
        groceryListItem item5 = new groceryListItem("Mleko");
        groceryListItem item6 = new groceryListItem("Piers z kurczaka 500g");

        groceries = new ArrayList<groceryListItem>();
        groceries.add(item1);
        groceries.add(item2);
        groceries.add(item3);
        groceries.add(item4);
        groceries.add(item5);
        groceries.add(item6);

        groceriesList.getItems().setAll(groceries);





    }


}
