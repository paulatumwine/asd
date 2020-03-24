package game;

public abstract class Level {
    protected int totalPoints;
    Game game;

    public Level() {
    }

    public Level(Game game, int totalPoints) {
        this.game = game;
        this.totalPoints = totalPoints;
    }

    public abstract int addPoints(int points);
    public abstract String getLevel();
}
