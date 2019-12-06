package game.backend.cell;

import game.backend.Grid;
import game.backend.element.*;

import java.util.Random;

public class FruitGeneratorCell extends CandyGeneratorCell {

    public FruitGeneratorCell(Grid grid) {
        super(grid);
    }

    @Override
    public Element getContent() {
        Random random = new Random();
        int number = random.nextInt(200);
        if(number > 1 ) {
            int i = (int) (Math.random() * CandyColor.values().length);
            return new Candy(CandyColor.values()[i]);
        }
        if(number == 1)
            return new Hazelnut();
        return new Cherry();
    }
}
