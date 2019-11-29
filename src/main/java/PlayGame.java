public class PlayGame {

    RandomNumber rn = new RandomNumber();
    PlayerInput p = new PlayerInput();
    int [] userInput = new int[3];

    public void playCmd() {
        rn.setNumber();
        userInput = p.getInput();
    }
}
