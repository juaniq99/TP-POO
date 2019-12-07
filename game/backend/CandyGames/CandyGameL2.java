package game.backend.CandyGames;

import game.backend.EnhancedGameState;
import game.backend.element.Element;
import game.backend.element.JailedCandy;
import game.backend.level.Level2;

public class CandyGameL2 extends CandyGame {

    private EnhancedGameState state;
    private Level2 grid;

    public CandyGameL2(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public EnhancedGameState getState() {return state; }

    @Override
    public Level2 getGrid() {return grid; }

    @Override
    public void initGame() {
        try {
            grid = (Level2) levelClass.newInstance();
        } catch(IllegalAccessException | InstantiationException e) {
            System.out.println("ERROR AL INICIAR");
        }
        this.state = (EnhancedGameState) getGrid().createState();
        getGrid().initialize();
        getGrid().setJails();
        addGameListener(this); // como necesitamos llamar a setJails no podemos llamar super initGame
                               // agregar el gameListener debe ser lo último que se hace en el método
    }

    @Override
    public void cellExplosion(Element e) {
        super.cellExplosion(e);
        if (e instanceof JailedCandy)
            getState().decreaseObjectiveCandies();
    }
}
