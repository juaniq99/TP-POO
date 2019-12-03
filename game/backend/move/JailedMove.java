package game.backend.move;

import game.backend.Grid;

public class JailedMove extends Move {

    public JailedMove(Grid grid) {
        super(grid);
    }

    @Override
    public void removeElements() {}

    @Override
    public boolean isValid() {return false; }
}
