package game;

public class Level1 extends Level {

    public Level1(Game game, int totalPoints) {
        super(game, totalPoints);
    }

    @Override
    public int addPoints(int newPoints) {
        totalPoints = totalPoints + newPoints;
        if (totalPoints > 10) { // move to level 2
            Level level = new Level2(game, totalPoints);
            game.setLevel(level);
            totalPoints = totalPoints + 1;//add 1 bonus point
        }
        return totalPoints;
    }

    public String getLevel() {
        return "1";
    }
}
