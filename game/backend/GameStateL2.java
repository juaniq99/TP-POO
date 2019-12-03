package game.backend;

public abstract class GameStateL2 extends GameState{

    protected int jailedCandies;

    public void setJailedCandies(int jailedCandies){
        this.jailedCandies = jailedCandies;
    }

    public int getJailedCandies() {
        return jailedCandies;
    }

    public void decreaseJailedCandies(){
        jailedCandies--;
    }
}
