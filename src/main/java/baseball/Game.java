package baseball;

    import camp.nextstep.edu.missionutils.Randoms;

    import java.util.ArrayList;
    import java.util.LinkedHashSet;
    import java.util.List;

public class Game {

    private final String START = "1";
    private final String END = "2";

    private boolean play = true;
    private Balls computer;

    public Game() {
        computer = new Balls(createRandomNumberList());
    }

    public void validateInput(String input) {
        if (!(input.equals(START)) && !(input.equals(END))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkhint(Hint hint) {
        if (hint.strike() == Balls.SIZE) {
            return true;
        }
        return false;
    }

    public void choicePlay(String input) {
        validateInput(input);
        if (input.equals(END)) {
            play = false;
            return;
        }
        computer = new Balls(createRandomNumberList());
    }

    public boolean isPlay() {
        return play;
    }

    public Balls getComputer() {
        return computer;
    }

    public List<Integer> createRandomNumberList() {
        LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < Balls.SIZE) {
            numberSet.add(Randoms.pickNumberInRange(Ball.MIN_VALUE, Ball.MAX_VALUE));
        }
        return new ArrayList<>(numberSet);
    }
}