package game.frontend;

import game.backend.CandyGames.CandyGameL3;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CandyFrameL3 extends CandyFrame {

    private static final int FRUITS = 4;
    private FruitsPanel fruitsPanel;

    public CandyFrameL3(CandyGameL3 game, GameApp gameApp, Stage stage) {
        super(game, gameApp, stage);
        fruitsPanel = new FruitsPanel(FRUITS);
        getChildren().add(fruitsPanel);

        addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String message = "Remaining fruits: " + game.getState().getObjectiveCandies();
            fruitsPanel.updateFruits(message);
        });
    }

}
