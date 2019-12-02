public class Main {

  public static void main(String args[]) {

    Game game = new Game();

    boolean playAgain = true;

    while (playAgain) {
      playAgain = game.start();
    }
  }
}
