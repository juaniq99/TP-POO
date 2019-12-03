package game.backend.level;

import game.backend.GameState;
import game.backend.GameStateL2;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Wall;

public class Level2 extends Level {

    private static int JAILED_CANDIES = 8;
    private static int MAX_MOVES = 20;

    @Override
    protected GameState newState() {
        return new Level2State(JAILED_CANDIES, MAX_MOVES);
    }

    private class Level2State extends GameStateL2 {
        private int jailedCandies;
        private long maxMoves;

        public Level2State(int jailedCandies, int maxMoves) {
            this.jailedCandies = jailedCandies;
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return jailedCandies == 0;
        }
    }

}