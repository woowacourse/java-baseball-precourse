package baseball;

public class Game {

    private final String START = "1";
    private final String END = "2";

    private boolean play = true;

    public Game() {
    }

    public void validateInput(String input) {
        if (!(input.equals(START)) && !(input.equals(END))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkhint(Hint hint) {
        if (hint.strike() == 3) {
            return true;
        }
        return false;
    }

    public void choicePlay(String input) {
        validateInput(input);
        if (input.equals(END)) {
            play = false;
        }
    }

    public boolean isPlay() {
        return play;
    }
}
