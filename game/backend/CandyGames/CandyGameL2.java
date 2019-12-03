package game.backend.CandyGames;

import game.backend.GameStateL2;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.JailedCandy;

public class CandyGameL2 extends CandyGame {

    private GameStateL2 state;

    public CandyGameL2(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public GameStateL2 getState() {return state; }

    @Override
    public void initGame() {
        try {
            grid = (Grid)levelClass.newInstance();
        } catch(IllegalAccessException | InstantiationException e) {
            System.out.println("ERROR AL INICIAR");
        }
        this.state = (GameStateL2) grid.createState();
        grid.initialize();
        grid.setJails();
        addGameListener(this);
    }

    @Override
    public void cellExplosion(Element e) {
        state.addScore(e.getScore());
        if (e instanceof JailedCandy)
            state.decreaseJailedCandies();
    }
}
