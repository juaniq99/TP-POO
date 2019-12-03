package game.backend.level;

import game.backend.GameStateL2;


public class Level2 extends Level {

    private static int JAILED_CANDIES = 8;
    private static int MAX_MOVES = 25;          // 5 movimientos más que en el nivel 1 porque este es más difícil

    @Override
    protected GameStateL2 newState() {
        return new Level2State(JAILED_CANDIES, MAX_MOVES);
    }

    private class Level2State extends GameStateL2 {
        private long maxMoves;

        public Level2State(int maxJailedCandies, int maxMoves) {
            setJailedCandies(maxJailedCandies);
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return getJailedCandies() <= 0;
        }
    }

}