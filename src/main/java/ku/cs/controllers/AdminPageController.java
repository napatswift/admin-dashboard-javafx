package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import ku.cs.CustomListView;

import java.io.IOException;
import java.time.LocalDateTime;

public class AdminPageController {
    @FXML
    SplitPane mainSplitPane;

    public void initialize() {
        ObservableList<CustomListView.CustomThing> data = FXCollections.observableArrayList();

        data.addAll(new CustomListView.CustomThing(LocalDateTime.now(), "userName"));

        final ListView<CustomListView.CustomThing> listView = new ListView<CustomListView.CustomThing>(data);
        listView.setCellFactory(new Callback<ListView<CustomListView.CustomThing>, ListCell<CustomListView.CustomThing>>() {
            @Override
            public ListCell<CustomListView.CustomThing> call(ListView<CustomListView.CustomThing> listView) {
                return new CustomListView.CustomListCell();
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<CustomListView.CustomThing>() {
                    @Override
                    public void changed(ObservableValue<? extends CustomListView.CustomThing> observableValue, CustomListView.CustomThing customThing, CustomListView.CustomThing t1) {

                    }
                }
        );

        mainSplitPane.getItems().addAll(listView, new AnchorPane());
        mainSplitPane.setDividerPosition(0, 0.25);
        mainSplitPane.setDividerPosition(1, 0.75);
    }
}
