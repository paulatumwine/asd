package game;

import java.util.Random;

public class Game {
	private Level level;

	public void play() {
		Random random = new Random();
		addPoints(random.nextInt(7)+3);
		System.out.println("points="+level.totalPoints+" level="+level.getLevel());
	}

	public int addPoints(int newPoints) {
		return level.addPoints(newPoints);
	}

    public void setLevel(Level level) {
        this.level = level;
    }
}
