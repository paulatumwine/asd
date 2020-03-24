package game;

public class Level2 extends Level {

    public Level2(Game game, int totalPoints) {
        super(game, totalPoints);
    }

    @Override
    public int addPoints(int newPoints) {
        totalPoints = totalPoints + 2 * newPoints;
        if (totalPoints >= 15) { // move to level 2_5
            Level level = new Level2_5(game, totalPoints);
            game.setLevel(level);
            totalPoints = totalPoints + 1; //add 1 bonus point
        }
        return totalPoints;
    }

    public String getLevel() {
        return "2";
    }
}
