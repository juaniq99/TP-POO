package game.backend;

public abstract class GameState {
	
	protected long score = 0;
	protected int moves = 0;
	protected int maxMoves = 20;

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

	public int getRemainingMoves() {
		int resp = maxMoves - getMoves();
		return resp > 0? resp : 0;
	}

	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

}
