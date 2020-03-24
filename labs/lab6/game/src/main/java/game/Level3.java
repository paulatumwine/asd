package game;

public class Level3 extends Level {

    public Level3(Game game, int totalPoints) {
        super(game, totalPoints);
    }

    @Override
    public int addPoints(int newPoints) {
        totalPoints = totalPoints + 3 * newPoints;
        return totalPoints;
    }

    public String getLevel() {
        return "3";
    }
}
