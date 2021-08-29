package ku.cs;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomListView {
    public static class CustomThing {
        private String string;
        private LocalDateTime time;

        public String getString() {
            return string;
        }

        public LocalDateTime getTime() {
            return time;
        }

        public String getTimeString(){
            String pattern = " HH:mm - d MMM";
            DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(pattern);
            return simpleDateFormat.format(time);
        }

        public CustomThing(LocalDateTime time, String string) {
            this.string = string;
            this.time = time;
        }
    }

    public static class CustomListCell extends ListCell<CustomThing> {
        private VBox content;
        private Label topLabel;
        private Label label;

        public CustomListCell() {
            topLabel = new Label();
            label = new Label();
            topLabel.setStyle("-fx-font-size: 16");
            label.setStyle("-fx-font-size: 24");
            content = new VBox(topLabel, label);
        }

        @Override
        protected void updateItem(CustomThing item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                topLabel.setText(item.getTimeString());
                label.setText(item.getString());
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }

}