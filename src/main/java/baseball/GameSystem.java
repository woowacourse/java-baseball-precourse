package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSystem {

    private final Player player;
    private final Checker checker;

    public GameSystem(Scanner scanner) {
        player = new Player(scanner);
        checker = new Checker();
    }

    public void getHint(int targetValue, int input) {
        char[] target = String.valueOf(targetValue).toCharArray();
        char[] guess = String.valueOf(input).toCharArray();
        int ball = 0 ;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (target[i] == guess[i]) {
                strike++;
            }

            if (String.valueOf(targetValue).contains(String.valueOf(guess[i]))) {
                ball++;
            }
        }

        ball -= strike;
        hintPrint(ball, strike);
    }

    private void hintPrint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(Message.NOTHING_MESSAGE);
        } else if (ball == 0) {
            Message.strikeMessage(strike);
        } else if (strike == 0) {
            Message.ballMessage(ball);
        } else {
            Message.ballAndStrikeMessage(ball, strike);
        }
    }

    public int getRandomValue() {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        int index = 1;

        do {
            int random = RandomUtils.nextInt(1, 9);
            if (!list.contains(random)) {
                list.add(random);
            }
        } while (list.size() < 3);

        for (Integer s : list) {
            result += s * index;
            index *= 10;
        }

        return result;
    }

    public int valueInsert() {
        int input;
        System.out.print(Message.INPUT_ASK_MESSAGE);
        input = player.valueInsert();
        checker.isValid(input);
        return input;
    }

    public boolean gameContinue() {
        int input;
        System.out.println(Message.CORRECT_MESSAGE);
        System.out.println(Message.CONTINUE_ASK_MESSAGE);
        input = player.gameContinue();
        if (input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException(Message.GAME_CONTINUE_INPUT_ERROR_MESSAGE);
        }
    }

    public boolean isCorrect(int targetValue, int input) {
        return checker.isCorrect(targetValue, input);
    }
}
