package game.backend.level;

import game.backend.EnhancedGameState;
import game.backend.cell.Cell;
import game.backend.cell.FruitGeneratorCell;
import game.backend.element.Cherry;
import game.backend.element.Fruit;
import game.backend.element.Hazelnut;

import java.util.Random;

public class Level3 extends Level {

    private final static int FRUIT_CANDIES = 4;
    private final static int MAX_MOVES = 25;
    private final static int INITIAL_FRUITS = 2;

    private Cell fruitGeneratorCell = new FruitGeneratorCell(this, INITIAL_FRUITS);

    @Override
    public void fallElements() {
        super.fallElements();
        for (int i = 0; i < SIZE ; i++) {
            if (g()[SIZE - 1][i].getContent() instanceof Fruit) {   //Para que llame otra vez si se borró una fruta de la última fila
                g()[SIZE - 1][i].clear();
                fallElements();
            }

        }
    }

    public void setFruits() {
        Random rn = new Random();
        int i = rn.nextInt(9);
        int j = rn.nextInt(9);
        while (get(0, i) instanceof Fruit)
            i = rn.nextInt(9);
        setContent(0,i,new Hazelnut());
        while(get(0, j) instanceof Fruit)
            j = rn.nextInt(9) ;
        setContent(0,j,new Cherry());
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

        public Level3State(int maxFruitCandies, int maxMoves) { //FIJAR SI HACER EN ENHANCED O DEJARLO ACA
            super(maxFruitCandies, maxMoves);
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
