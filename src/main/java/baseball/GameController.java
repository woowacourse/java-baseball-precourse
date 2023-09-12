package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

import static baseball.constants.GameMessages.*;
import static baseball.constants.InputConstants.NUMBER_LENGTH;

public class GameController {
    private String answer;
    private String input;

    public void initGame() {
        HashSet<Character> set = new HashSet<>();
        int newNum;
        answer = "";

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            newNum = Randoms.pickNumberInRange(1, 9);
            while (set.contains((char)(newNum + '0'))) {
                newNum = Randoms.pickNumberInRange(1, 9);
            }
            answer = answer.concat(String.valueOf(newNum));
            set.add((char)(newNum + '0'));
        }
    }

    public void askRestart() {
        System.out.println(RESTART_MESSAGE);
        try {
            input = InputController.getRestart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (input.equals("1")) {
            run();
        } else {
            System.out.println(END_MESSAGE);
        }
    }

    public void run() {
        System.out.println(START_MESSAGE);
        initGame();
        do {
            try {
                System.out.print(INPUT_MESSAGE);
                input = InputController.getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!playGame());
        askRestart();
    }

    public boolean playGame() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (answer.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }

        switch (strike) {
            case 0:
                if (ball == 0) {
                    System.out.println(NOTHING_MESSAGE);
                } else {
                    System.out.printf((BALL_MESSAGE) + "%n", ball);
                }
                break;
            case 3:
                System.out.printf((STRIKE_MESSAGE) + "%n", strike);
                System.out.println(WIN_MESSAGE);
                break;
            default:
                if (ball == 0) {
                    System.out.printf((STRIKE_MESSAGE) + "%n", strike);
                } else {
                    System.out.printf((BALL_AND_STRIKE_MESSAGE) + "%n", ball, strike);
                }
        }
        return strike == NUMBER_LENGTH;
    }
}
