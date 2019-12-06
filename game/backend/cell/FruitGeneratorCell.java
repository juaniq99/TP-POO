package game.backend.cell;

import game.backend.Grid;
import game.backend.element.*;

import java.util.Random;

public class FruitGeneratorCell extends CandyGeneratorCell {

    private int fruitsToGen;

    public FruitGeneratorCell(Grid grid, int maxFruitsToGen) {
        super(grid);
        this.fruitsToGen = maxFruitsToGen;
    }

    @Override
    public Element getContent() {
        if (getFruitsToGen() > 0) {
            Random random = new Random();
            int number = random.nextInt(100 * getFruitsToGen()); //Para que a medida que falten aparecer menos, las
            if (number == 0) {                                           // posibilidades de que aparezca una fruta sean mayores
                decreaseFruitsToGen();
                return new Cherry();
            }
            if (number == 1) {
                decreaseFruitsToGen();
                return new Hazelnut();
            }
        }
        int i = (int) (Math.random() * CandyColor.values().length);
        return new Candy(CandyColor.values()[i]);
    }

    public int getFruitsToGen() {
        return fruitsToGen;
    }

    public void decreaseFruitsToGen(){
        fruitsToGen -= 1;
    }
}
