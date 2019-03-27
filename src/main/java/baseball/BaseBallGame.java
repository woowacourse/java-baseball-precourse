package baseball;

import java.util.Scanner;

public class BaseBallGame {
    private final static int RESTART = 1;
    private final static int END = 2;
    private final int DIGIT_LENGTH;
    private Computer computer;
    private Player player;
    private int ball;
    private int strike;

    public BaseBallGame(int digitLength) {
        this.DIGIT_LENGTH = digitLength;
    }

    public void run() {
        computer = new Computer(DIGIT_LENGTH);
        player = new Player(DIGIT_LENGTH);

        do {
            start();
        } while (restart());
    }

    private void start() {
        computer.generateDigits();

        do {
            player.inputDigits();

            compareDigits(computer.getDigits(), player.getDigits());

            System.out.println(getResult());
        } while (!isGameClear());

        System.out.println(DIGIT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void compareDigits(String comNums, String playerNums) {
        initBallAndStrike();

        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (matchSameIndex(comNums, playerNums, i))
                strike++;
            else if (matchDifferentIndex(comNums, playerNums, i))
                ball++;
        }
    }

    private void initBallAndStrike() {
        ball = 0;
        strike = 0;
    }

    private boolean matchSameIndex(String comNums, String playerNums, int index) {
        return comNums.charAt(index) == playerNums.charAt(index);
    }

    private boolean matchDifferentIndex(String comNums, String playerNums, int index) {
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (i != index && playerNums.charAt(index) == comNums.charAt(i))
                return true;
        }
        return false;
    }

    private String getResult() {
        if (isNothing())
            return "낫싱";

        return printStrike() + printBall();
    }

    private Boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private String printStrike() {
        return (strike == 0) ? "" : strike + " 스트라이크";
    }

    private String printBall() {
        return (ball == 0) ? "" : ball + " 볼";
    }

    private boolean isGameClear() {
        return strike == DIGIT_LENGTH;
    }

    private boolean restart() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int command = sc.nextInt();
            if (command == RESTART)
                return true;
            else if (command == END)
                return false;

            System.out.println("잘못 입력하셨습니다.");
        }
    }
}
