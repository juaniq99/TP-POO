package game.backend.CandyGames;

import game.backend.EnhancedGameState;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.level.Level3;

public class CandyGameL3 extends CandyGame {
    private EnhancedGameState state;
    private Level3 grid;

    public CandyGameL3(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public EnhancedGameState getState() {return state; }

    @Override
    public Level3 getGrid() {return grid; }

    @Override
    public void initGame() {
        try {
            grid = (Level3) levelClass.newInstance();
        } catch(IllegalAccessException | InstantiationException e) {
            System.out.println("ERROR AL INICIAR");
        }
        this.state = (EnhancedGameState) getGrid().createState();
        getGrid().initialize();
        getGrid().setFruits();
        addGameListener(this); // como necesitamos llamar a setFruits no podemos hacer super initGame
    }

    @Override
    public void cellExplosion(Element e) {
        super.cellExplosion(e);
        if (e instanceof Fruit)
            getState().decreaseObjectiveCandies();
    }
}
