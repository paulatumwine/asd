package game;

public class Level2 extends Level {

    public Level2(Game game, int totalPoints) {
        super(game, totalPoints);
    }

    @Override
    public int addPoints(int newPoints) {
        totalPoints = totalPoints + 2 * newPoints;
        if (totalPoints > 20) { // move to level 3
            Level level = new Level3(game, totalPoints);
            game.setLevel(level);
            totalPoints = totalPoints + 2; //add 2 bonus points
        }
        return totalPoints;
    }

    public int getLevel() {
        return 2;
    }
}
