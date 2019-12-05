package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MovementsPanel extends BorderPane {

    private Label movementsLabel;

    public MovementsPanel() {
        setStyle("-fx-background-color: #5490ff");
        movementsLabel = new Label("Movements used: 0");
        movementsLabel.setAlignment(Pos.CENTER);
        movementsLabel.setStyle("-fx-font-size: 24");
        setCenter(movementsLabel);
    }

    public void updateMovements(String text) {
        movementsLabel.setText("Movements used: " + text);
    }

}