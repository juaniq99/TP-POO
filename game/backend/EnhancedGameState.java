package game.backend;

public abstract class EnhancedGameState extends GameState{

    protected int objectiveCandies;

    public EnhancedGameState(int maxObjectiveCandies, int maxMoves) {
        setObjectiveCandies(maxObjectiveCandies);
        this.maxMoves = maxMoves;
    }

    public void setObjectiveCandies(int objectiveCandies){
        this.objectiveCandies = objectiveCandies;
    }

    public int getObjectiveCandies() {
        return objectiveCandies;
    }

    public void decreaseObjectiveCandies(){
        objectiveCandies--;
    }
}
