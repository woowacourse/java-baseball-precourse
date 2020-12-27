package baseball;

public class BaseballController {
    private Baseball baseball;
    private BaseballIO io;
    private boolean playing;

    public BaseballController(Baseball baseball, BaseballIO io) {
        this.baseball = baseball;
        this.io = io;
        this.playing = true;
    }

    public void doGame() {
        int[] input = io.getInput();
        int[] result = getResult(input);
        io.printResult(result);

        if (result[1] == 3) {
            boolean restart = io.willRestart();
            if (restart) {
                baseball.rand();
            }
            else {
                playing = false;
            }
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public int[] getResult(int[] input) {
        int[] result = {0, 0}; // 볼, 스트라이크
        for (int i=0; i<3; i++) {
            if (baseball.numberAt(i) == input[i]) {
                result[1]++;
            }
            else if (hasBall(input[i])) {
                result[0]++;
            }
        }
        return result;
    }

    private boolean hasBall(int input) {
        for (int i=0; i<3; i++) {
            if (baseball.numberAt(i) == input) {
                return true;
            }
        }
        return false;
    }
}
