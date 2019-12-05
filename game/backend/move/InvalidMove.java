package game.backend.move;

import game.backend.Grid;

public class InvalidMove extends Move {

    public InvalidMove(Grid grid) {
        super(grid);
    }

    @Override
    public void removeElements() {}

    @Override
    public boolean isValid() {return false; }
}
