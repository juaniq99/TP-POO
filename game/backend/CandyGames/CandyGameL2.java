package game.backend.CandyGames;

public class CandyGameL2 extends CandyGame {

    public CandyGameL2(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public void initGame() {
        super.initGame();
        grid.setJails();
    }
}
