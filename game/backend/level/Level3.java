package game.backend.level;

import game.backend.EnhancedGameState;
import game.backend.cell.Cell;
import game.backend.cell.FruitGeneratorCell;
import game.backend.element.Fruit;

public class Level3 extends Level {

    private final static int FRUIT_CANDIES = 4;
    private final static int MAX_MOVES = 25;

    private Cell fruitGeneratorCell = new FruitGeneratorCell(this);

    @Override
    public void fallElements() {
        super.fallElements();
        for (int i = 0; i < SIZE ; i++) {
            if (g()[SIZE - 1][i].getContent().equals(new Fruit())) {
                g()[SIZE - 1][i].clear();
                fallElements();
            }

        }
    }



    @Override
    public Cell getCandyGenCell(){ //Hacemos esto para no tener que pisar todo el metodo fill cells
        return fruitGeneratorCell;
    }

    @Override
    protected EnhancedGameState newState() {
        return new Level3.Level3State(FRUIT_CANDIES, MAX_MOVES);
    }

    private class Level3State extends EnhancedGameState {
        private long maxMoves;

        public Level3State(int maxFruitCandies, int maxMoves) { //FIJAR SI HACER EN ENHANCED O DEJARLO ACA
            setObjectiveCandies(maxFruitCandies);
            this.maxMoves = maxMoves;
        }

        @Override
        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        @Override
        public boolean playerWon() {
            return getObjectiveCandies() <= 0;
        }
    }
}
