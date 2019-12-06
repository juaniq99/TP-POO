package game.backend;

public abstract class EnhancedGameState extends GameState{

    protected int objectiveCandies;
    protected long maxMoves;

    public void setObjectiveCandies(int objectiveCandies){
        this.objectiveCandies = objectiveCandies;
    }

    public EnhancedGameState(int maxObjectiveCandies, int maxMoves) {
        setObjectiveCandies(maxObjectiveCandies);
        this.maxMoves = maxMoves;
    }

    public int getObjectiveCandies() {
        return objectiveCandies;
    }

    public void decreaseObjectiveCandies(){
        objectiveCandies--;
    }
}
