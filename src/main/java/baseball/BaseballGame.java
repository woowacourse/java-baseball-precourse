package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Message.*;

public class BaseballGame {

    private Computer computer;

    public void gameStart() {
        this.computer = new Computer();
        User user;
        do {
            user = input();
        } while (!numberCheck(computer.getAnswer(), user.getUserNumbers()));
    }

    public User input() {
        System.out.println(INPUT_NUMBERS);
        String userInput = Console.readLine();
        return new User(userInput);

    }

    boolean numberCheck(List<Integer> answer, List<Integer> User) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(User.get(i)))
                strike++;

            ball += ballCheck(answer, User.get(i), i);
        }

        printScore(strike, ball);

        return strike == 3;
    }

    void printScore(int strike, int ball) {

        if (ball != 0)
            System.out.print(ball + BALL + " ");
        if (strike != 0)
            System.out.print(strike + STRIKE);
        if (strike == 3) {
            System.out.print(FINISH_MESSAGE);
        } else if (strike == 0 && ball == 0) {
            System.out.print(NOTHING);
        }
        System.out.print('\n');
    }

    int ballCheck(List<Integer> answer, int num, int idx) {
        int ball = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (i == idx)
                continue;
            if (answer.get(i) == num)
                ball++;
        }
        return ball;
    }
}