package ku.cs;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CustomListView {
    public static class CustomThing {
        private String name;
        private int price;
        public String getName() {
            return name;
        }
        public int getPrice() {
            return price;
        }
        public CustomThing(String name, int price) {
            super();
            this.name = name;
            this.price = price;
        }
    }

    public static class CustomListCell extends ListCell<CustomThing> {
        private HBox content;
        private Text name;
        private Text price;

        public CustomListCell() {
            name = new Text();
            price = new Text();
            VBox vBox = new VBox(name, price);
            content = new HBox(new Label("[Graphic]"), vBox);
            content.setSpacing(10);
        }

        @Override
        protected void updateItem(CustomThing item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                name.setText(item.getName());
                price.setText(String.format("%d $", item.getPrice()));
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }

}