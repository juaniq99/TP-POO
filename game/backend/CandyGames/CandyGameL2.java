package game.backend.CandyGames;

import game.backend.EnhancedGameState;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.JailedCandy;

public class CandyGameL2 extends CandyGame {

    private EnhancedGameState state;

    public CandyGameL2(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public EnhancedGameState getState() {return state; }

    @Override
    public void initGame() {
        try {
            grid = (Grid)levelClass.newInstance();
        } catch(IllegalAccessException | InstantiationException e) {
            System.out.println("ERROR AL INICIAR");
        }
        this.state = (EnhancedGameState) grid.createState();
        grid.initialize();
        grid.setJails();
        addGameListener(this); // COMO NECESITABAMOS HACER setJails no pudimos acer super initGame

    }

    @Override
    public void cellExplosion(Element e) {
        super.cellExplosion(e);
        if (e instanceof JailedCandy)
            state.decreaseObjectiveCandies();
    }
}
