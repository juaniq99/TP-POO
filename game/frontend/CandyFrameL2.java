package game.frontend;

import game.backend.CandyGames.CandyGameL2;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CandyFrameL2 extends CandyFrame {

    private static final int JAILED_CANDIES = 8;
    private JailsPanel jailsPanel;

    public CandyFrameL2(CandyGameL2 game, GameApp gameApp, Stage stage) {
        super(game, gameApp, stage);
        jailsPanel = new JailsPanel(JAILED_CANDIES);
        getChildren().add(jailsPanel);

        addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String message = "Remaining jails: " + game.getState().getObjectiveCandies();
            jailsPanel.updateJails(message);
        });
    }
}
