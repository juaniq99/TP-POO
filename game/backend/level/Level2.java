package game.backend.level;

import game.backend.EnhancedGameState;


public class Level2 extends Level {

    private final static int JAILED_CANDIES = 8;
    private final static int MAX_MOVES = 25;          // 5 movimientos más que en el nivel 1 porque este es más difícil

    @Override
    protected EnhancedGameState newState() {
        return new Level2State(JAILED_CANDIES, MAX_MOVES);
    }

    private class Level2State extends EnhancedGameState {


        public Level2State(int maxFruitCandies, int maxMoves) {
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