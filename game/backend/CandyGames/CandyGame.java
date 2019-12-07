package game.backend.CandyGames;

import game.backend.GameListener;
import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.element.Element;

public class CandyGame implements GameListener {
	
	protected Class<?> levelClass;
	protected Grid grid;
	protected GameState state;
	
	public CandyGame(Class<?> clazz) {
		this.levelClass = clazz;
	}

	public GameState getState() {return state; }

	public Grid getGrid() {return grid; }
	
	public void initGame() {
		try {
			grid = (Grid)levelClass.newInstance();
		} catch(IllegalAccessException | InstantiationException e) {
			System.out.println("ERROR AL INICIAR");
		}
		this.state = getGrid().createState();
		getGrid().initialize();
		addGameListener(this);
	}
	
	public int getSize() {
		return Grid.SIZE;
	}
	
	public boolean tryMove(int i1, int j1, int i2, int j2){
		return getGrid().tryMove(i1, j1, i2, j2);
	}
	
	public Cell get(int i, int j){
		return getGrid().getCell(i, j);
	}
	
	public void addGameListener(GameListener listener) {
		getGrid().addListener(listener);
	}
	
	public long getScore() {
		return getState().getScore();
	}
	
	public boolean isFinished() {
		return getState().gameOver();
	}
	
	public boolean playerWon() {
		return getState().playerWon();
	}
	
	@Override
	public void cellExplosion(Element e) {
		getState().addScore(e.getScore());
	}
	
	@Override
	public void gridUpdated() {
		//
	}

}
