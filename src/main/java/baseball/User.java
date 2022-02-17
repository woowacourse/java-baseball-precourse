package baseball;

public class User {

    private int[] userAnswer;
    private int[] computerAnswer;
    private final String RESTART_GAME = "1";
    private final String TERMINATE_GAME = "2";
    private int strike;
    private int ball;

    /**
     * "Scope" 를 생각해보는 것도 좋을거 같다.
     *
     * computerAnswer _ 정답을 맞출 때까지
     *
     * userAnswer / strike / ball _ 이번 답 입력까지
     *
     */
    public User() {
        userAnswer = new int[3];
    }

    public void startGame() {
        Computer computer = new Computer();
        computerAnswer = computer.getAnswer();
        inputNum(Input.userNumber());
    }

    public void inputNum(String userNumber) {

        for (int i = 0; i < 3; i++) {
            userAnswer[i] = userNumber.charAt(i) - '0';
        }
        Output.cheatVersion(computerAnswer);
        digitBingo();
    }

    private void digitBingo() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkDigit(i, j);
            }
        }
        gameStatus();
    }

    private void gameStatus() {
        if (gameOver() == Output.GAME_FINISH) {
            Output.requestRestart();
            String restartInput = Input.restartGame();

            if (restartInput == RESTART_GAME) {

            } else if (restartInput == TERMINATE_GAME) {
                return;
            }
        } else {
            inputNum(Input.userNumber());
        }
    }

    private void checkDigit(int i, int j) { // 00 01 02 11 12 22
        if (computerAnswer[i] == userAnswer[j]) {
            if (i == j) {
                ++strike;
            } else {
                ++ball;
            }
        }
    }

    private int result(int ball, int strike) {
        Output.scoreResult(ball, strike);
        return strike;
    }

    private int gameOver() {
        if (result(ball, strike) == Output.GAME_FINISH) {
            return Output.GAME_FINISH;
        }
        return Output.GAME_CONTINUE;
    }
}
