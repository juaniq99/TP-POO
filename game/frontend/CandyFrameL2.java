package game.frontend;

import game.backend.CandyGames.CandyGame;
import game.backend.CandyGames.CandyGameL2;

public class CandyFrameL2 extends CandyFrame {

    private static final int JAILED_CANDIES = 8;
    private JailsPanel jailsPanel;

    public CandyFrameL2(CandyGameL2 game) {
        super(game);
        jailsPanel = new JailsPanel(JAILED_CANDIES);
        getChildren().add(jailsPanel);
    }
}
