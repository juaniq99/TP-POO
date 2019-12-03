package game.backend.element;

public class JailedCandy extends Candy {

    public JailedCandy() {
    }

    public JailedCandy(CandyColor color){
        super(color);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public String getKey() {
        return "JAILED-" + super.getKey(); }

    @Override
    public String getFullKey() {
        return "JAILED-" + super.getFullKey();
    }

    @Override
    public long getScore() {
        return 100;
    }
}
