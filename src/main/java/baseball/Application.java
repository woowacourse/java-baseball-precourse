package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int START_GAME_VALUE = 1;
    private static final int END_GAME_VALUE = 2;

    public static void main(String[] args) {
        int gameStatus = START_GAME_VALUE;
        Game game = new Game();

        while (gameStatus != END_GAME_VALUE) {
            game.start();
            playGame();
        }
    }

    private static void playGame() {
        List<Integer> playerInput;

        while(true) {
            playerInput = getPlayerInput();

            // TODO : userInput을 검증하고, 결과를 찾는다.
        }
    }

    private static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        String[] splitInput = input.split("");

        return Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
    }
}

class Game {
    Answer answer;

    public Game() {

    }

    public void start() {
        this.answer = new Answer();
    }
}

class Answer {
    List<Integer> numbers;

    public Answer() {
        initAnswer();
    }

    private void initAnswer() {
        for (int i = 0; i < 3; i++) {
            numbers.add(getUniqueNumber());
        }
    }

    private int getUniqueNumber() {
        int number;

        while(true) {
            number = Randoms.pickNumberInRange(0, 9);

            if (!numbers.contains(number)) return number;
        }
    }
}
