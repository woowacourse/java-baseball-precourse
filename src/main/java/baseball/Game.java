package baseball;

public class Game {

    private final String START = "1";
    private final String END = "2";

    public Game() {
    }

    public void validateInput(String input) {
        if (!(input.equals(START)) || !(input.equals(END))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkhint(Hint hint) {
        if (hint.strike() == 3) {
            return true;
        }
        return false;
    }
}
