package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class JailsPanel extends BorderPane {

    private Label JailsLabel;

    public JailsPanel(int jailedCandies) {
        setStyle("-fx-background-color: #5490ff");
        JailsLabel = new Label("Remaining jails: " + jailedCandies);
        JailsLabel.setAlignment(Pos.CENTER);
        JailsLabel.setStyle("-fx-font-size: 24");
        setCenter(JailsLabel);
    }

    public void updateJails(String text) {
        JailsLabel.setText(text);
    }

}