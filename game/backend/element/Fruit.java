package game.backend.element;

public class Fruit extends Element { //CAMBIAR A ENUM

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        return obj instanceof Fruit;
    }

    @Override
    public boolean isExplosive() {
        return false;
    }

    @Override
    public String getKey() {
        return "FRUIT";
    }
}
