package game.backend.CandyGames;

import game.backend.EnhancedGameState;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.element.JailedCandy;

public class CandyGameL3 extends CandyGame {
    private EnhancedGameState state;

    public CandyGameL3(Class<?> clazz) {
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
        grid.setFruits();
        addGameListener(this); // COMO NECESITABAMOS HACER setFruits no pudimos acer super initGame
    }

    @Override
    public void cellExplosion(Element e) {
        super.cellExplosion(e);
        if (e instanceof Fruit)
            state.decreaseObjectiveCandies();
    }
}
