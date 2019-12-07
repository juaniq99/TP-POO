package game.backend.move;

import game.backend.Grid;
import game.backend.element.*;

import java.util.HashMap;
import java.util.Map;

public class MoveMaker {

	private Map<String, Move> map;
	private Grid grid;
	private CandyMove candyMove;
	private BombMove bombMove;
	private BombStrippedMove bombStrippedMove;
	private BombWrappedMove bombWrappedMove;
	private InvalidMove invalidMove;
	private TwoBombMove twoBombMove;
	private TwoWrappedMove twoWrappedMove;
	private TwoStripedMove twoStripedMove;
	private WrappedStripedMove wrappedStripedMove;

	public MoveMaker(Grid grid) {
		this.grid = grid;
		candyMove = new CandyMove(grid);
		bombMove = new BombMove(grid);
		bombStrippedMove = new BombStrippedMove(grid);
		bombWrappedMove = new BombWrappedMove(grid);
		invalidMove = new InvalidMove(grid);
		twoBombMove = new TwoBombMove(grid);
		twoWrappedMove = new TwoWrappedMove(grid);
		twoStripedMove = new TwoStripedMove(grid);
		wrappedStripedMove = new WrappedStripedMove(grid);
		initMap();
	}

	private void initMap(){
		map = new HashMap<>();
		map.put(new Candy().getKey() + new Candy().getKey(), candyMove);
		map.put(new Candy().getKey() + new HorizontalStripedCandy().getKey(), candyMove);
		map.put(new Candy().getKey() + new VerticalStripedCandy().getKey(), candyMove);
		map.put(new Candy().getKey() + new WrappedCandy().getKey(), candyMove);
		map.put(new Candy().getKey() + new Bomb().getKey(), bombMove);
		map.put(new Candy().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new Candy().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new Candy().getKey() + new Fruit().getKey(), candyMove);

		map.put(new HorizontalStripedCandy().getKey() + new Candy().getKey(), candyMove);
		map.put(new HorizontalStripedCandy().getKey() + new HorizontalStripedCandy().getKey(), twoStripedMove);
		map.put(new HorizontalStripedCandy().getKey() + new VerticalStripedCandy().getKey(), twoStripedMove);
		map.put(new HorizontalStripedCandy().getKey() + new WrappedCandy().getKey(), wrappedStripedMove);
		map.put(new HorizontalStripedCandy().getKey() + new Bomb().getKey(), bombStrippedMove);
		map.put(new HorizontalStripedCandy().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new HorizontalStripedCandy().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new HorizontalStripedCandy().getKey() + new Fruit().getKey(), candyMove);

		map.put(new VerticalStripedCandy().getKey() + new Candy().getKey(), candyMove);
		map.put(new VerticalStripedCandy().getKey() + new HorizontalStripedCandy().getKey(), twoStripedMove);
		map.put(new VerticalStripedCandy().getKey() + new VerticalStripedCandy().getKey(), twoStripedMove);
		map.put(new VerticalStripedCandy().getKey() + new WrappedCandy().getKey(), wrappedStripedMove);
		map.put(new VerticalStripedCandy().getKey() + new Bomb().getKey(), bombStrippedMove);
		map.put(new VerticalStripedCandy().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new VerticalStripedCandy().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new VerticalStripedCandy().getKey() + new Fruit().getKey(), candyMove);

		map.put(new WrappedCandy().getKey() + new Candy().getKey(), candyMove);
		map.put(new WrappedCandy().getKey() + new HorizontalStripedCandy().getKey(), wrappedStripedMove);
		map.put(new WrappedCandy().getKey() + new VerticalStripedCandy().getKey(), wrappedStripedMove);
		map.put(new WrappedCandy().getKey() + new WrappedCandy().getKey(), twoWrappedMove);
		map.put(new WrappedCandy().getKey() + new Bomb().getKey(), bombWrappedMove);
		map.put(new WrappedCandy().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new WrappedCandy().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new WrappedCandy().getKey() + new Fruit().getKey(), candyMove);

		map.put(new Bomb().getKey() + new Candy().getKey(), bombMove);
		map.put(new Bomb().getKey() + new HorizontalStripedCandy().getKey(), bombStrippedMove);
		map.put(new Bomb().getKey() + new VerticalStripedCandy().getKey(), bombStrippedMove);
		map.put(new Bomb().getKey() + new WrappedCandy().getKey(), bombWrappedMove);
		map.put(new Bomb().getKey() + new Bomb().getKey(), twoBombMove);
		map.put(new Bomb().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new Bomb().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new Bomb().getKey() + new Fruit().getKey(), candyMove);

		map.put(new JailedCandy().getKey() + new Candy().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new HorizontalStripedCandy().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new VerticalStripedCandy().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new WrappedCandy().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new Bomb().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new JailedCandy().getKey() + new Fruit().getKey(), invalidMove); //Agregamos por si quieren hacer mezcla de niveles

		map.put(new Nothing().getKey() + new Candy().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new HorizontalStripedCandy().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new VerticalStripedCandy().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new WrappedCandy().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new Bomb().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new Nothing().getKey(), invalidMove);
		map.put(new Nothing().getKey() + new Fruit().getKey(), invalidMove);

		map.put(new Fruit().getKey() + new Candy().getKey(), candyMove);
		map.put(new Fruit().getKey() + new HorizontalStripedCandy().getKey(), candyMove);
		map.put(new Fruit().getKey() + new VerticalStripedCandy().getKey(), candyMove);
		map.put(new Fruit().getKey() +  new WrappedCandy().getKey(), candyMove);
		map.put(new Fruit().getKey() + new Bomb().getKey() , candyMove);
		map.put(new Fruit().getKey() + new JailedCandy().getKey(), invalidMove);
		map.put(new Fruit().getKey() + new Nothing().getKey() , invalidMove);
		map.put(new Fruit().getKey() + new Fruit().getKey(), invalidMove);



	}

	public Move getMove(int i1, int j1, int i2, int j2) {
		Move move = map.get(grid.get(i1, j1).getKey() + grid.get(i2, j2).getKey());
		move.setCoords(i1, j1, i2, j2);
		return move;
	}

}