package game.backend;

public abstract class EnhancedGameState extends GameState{

    protected int objectiveCandies;

    public void setObjectiveCandies(int objectiveCandies){
        this.objectiveCandies = objectiveCandies;
    }

   // public EnhancedGameState(int maxFruitCandies, int maxMoves) {
     //   setObjectiveCandies(maxFruitCandies);
       // this.maxMoves = maxMoves;
    //}

    public int getObjectiveCandies() {
        return objectiveCandies;
    }

    public void decreaseObjectiveCandies(){
        objectiveCandies--;
    }
}
