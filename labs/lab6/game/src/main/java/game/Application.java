package game;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		Level level = new Level1(game, 0);
		game.setLevel(level);
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}
