package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    private static final int START_GAME_VALUE = 1;
    private static final int END_GAME_VALUE = 2;
    private static final String PLAYER_INPUT_PATTERN = "^[0-9]{3}+$";
    private static final String RESTART_INPUT_PATTERN = "^[1-2]$";

    private static final String GAME_ENDING_OUTPUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final Game game = new Game();

    public static void main(String[] args) {
        int gameStatus = START_GAME_VALUE;

        while (gameStatus != END_GAME_VALUE) {
            game.start();
            playGame();

            gameStatus = restartGame();
        }
    }

    private static void playGame() {
        List<Integer> playerInput;
        Result result;

        do {
            playerInput = getPlayerInput();

            result = game.tryBaseball(playerInput);
            System.out.println(result.toString());

        } while (!result.isStrikeOut());

        System.out.println(GAME_ENDING_OUTPUT);
    }

    private static int restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getRestartInput();
    }

    private static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        validatePlayerInput(input);

        String[] splitInput = input.split("");

        return Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validatePlayerInput(String input) {
        if (!Pattern.matches(PLAYER_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    private static int getRestartInput() {
        String input = Console.readLine();
        validateRestartInput(input);

        return Integer.parseInt(input);
    }

    private static void validateRestartInput(String input) {
        if (!Pattern.matches(RESTART_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }
}

class Game {
    Answer answer;

    public Game() {

    }

    public void start() {
        this.answer = new Answer();
    }

    public Result tryBaseball(List<Integer> playerNumbers) {
        Result result = new Result(0,0);

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.isStrike(i, playerNumbers.get(i))) {
                result.addStrike();

                continue;
            }

            if (answer.isBall(playerNumbers.get(i))) {
                result.addBall();
            }
        }


        return result;
    }
}

class Answer {
    List<Integer> numbers;

    public Answer() {
        initAnswer();
    }

    private void initAnswer() {
        numbers = new ArrayList<>();

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

    public boolean isStrike(int idx, int number) {
        return numbers.get(idx) == number;
    }

    public boolean isBall(int number) {
        return numbers.contains(number);
    }
}

class Result {
    int strike;
    int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    public void addStrike() {
        strike ++;
    }

    public void addBall() {
        ball ++;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) return "낫싱";
        if (ball == 0) return strike + "스트라이크";
        if (strike == 0) return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
}