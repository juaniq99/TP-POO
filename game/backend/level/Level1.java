package game.backend.level;

import game.backend.GameState;

public class Level1 extends Level {
	
	private static int REQUIRED_SCORE = 5000; 
	private static int MAX_MOVES = 20;
	
	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}
	
	private class Level1State extends GameState {
		private long requiredScore;
		private int maxMoves;
		
		public Level1State(long requiredScore, int maxMoves) {
			this.requiredScore = requiredScore;
			this.maxMoves = maxMoves;
		}
		
		public boolean gameOver() {
			return playerWon() || getMoves() >= maxMoves;
		}
		
		public boolean playerWon() {
			return getScore() > requiredScore;
		}
	}

}
