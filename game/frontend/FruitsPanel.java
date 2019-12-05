package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FruitsPanel extends BorderPane {

    private Label FruitsLabel;

    public FruitsPanel(int Fruits) {
        setStyle("-fx-background-color: #5490ff");
        FruitsLabel = new Label("Remaining fruits: " + Fruits);
        FruitsLabel.setAlignment(Pos.CENTER);
        FruitsLabel.setStyle("-fx-font-size: 24");
        setCenter(FruitsLabel);
    }

    public void updateFruits(String text) {
        FruitsLabel.setText(text);
    }
}
