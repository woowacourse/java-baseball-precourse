package baseball;

public class BaseBallGame {
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

        start();
    }

    private void start() {
        computer.generateDigits();

        do {
            player.inputDigits();

            compareDigits(computer.getDigits(), player.getDigits());

            System.out.println(getResult());
        } while (true);

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

}
