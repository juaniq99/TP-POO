package game.backend.level;

import game.backend.EnhancedGameState;
import game.backend.element.Candy;
import game.backend.element.JailedCandy;


public class Level2 extends Level {

    private final static int JAILED_CANDIES = 8;
    private final static int MAX_MOVES = 25;          // 5 movimientos más que en el nivel 1 porque este es más difícil

    @Override
    protected EnhancedGameState newState() {
        return new Level2State(JAILED_CANDIES, MAX_MOVES);
    }

    public void setJails(){
        for (int j = 0; j <= SIZE-1; j++){
            if (j != 4){
                setContent(4, j, new JailedCandy(((Candy)get(4, j)).getColor()));
            }
        }
    }

    private class Level2State extends EnhancedGameState {

        public Level2State(int maxJailedCandies, int maxMoves) {
            super(maxJailedCandies, maxMoves);
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