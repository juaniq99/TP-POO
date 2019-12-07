package game.backend.element;

public class Fruit extends Element { //CAMBIAR A ENUM

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return false;    //Para que no intente hacer combinaciones de 3 o más frutas iguales en combo en tryRemove
    }

    @Override
    public boolean isRemovable() {
        return false;
    }

    @Override
    public String getKey() {
        return "FRUIT";
    }

    @Override
    public boolean affectedBySpecials() { return false; }
}
