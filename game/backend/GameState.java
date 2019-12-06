package game.backend;

public abstract class GameState {
	
	protected long score = 0;
	protected int moves = 0;
	protected long maxMoves = 20;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}
	
	public void addMove() {
		moves++;
	}

	public int getMoves() {
		return moves;
	}

	public long getRemainingMoves() {
		return maxMoves - getMoves();
	}

	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

}
