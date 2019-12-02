import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private int strikeCount;
    private int ballCount;
    private Computer myComputer;
    private Player myPlayer;
    private Scanner in;

    public Game() {
        myComputer = new Computer();
        myPlayer = new Player();
        in = new Scanner(System.in);
    }

    private void run() {
        String input;
        String playerResult;
        boolean isRun = true;

        do {
            System.out.print(Constant.STR_INPUT);
            input = in.next();
            playerResult = myPlayer.inputNumber(input);
            isRun = checkResult(playerResult);
        } while (isRun);
    }

	private boolean checkResult(String result) {
		switch (result) {
		case Constant.STR_EMPTY:
			return compareNumber();
		default:
			System.out.println(result);
			return true;
		}
	}

    private boolean compareNumber() {
        ArrayList<Integer> list = myComputer.getNumberSet();
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < Constant.NUM_SIZE; i++) {
            isSame(list.get(i), i);
        }
        if (strikeCount != Constant.NUM_SIZE) {
            printStrike();
            printBall();
            printNothing();
            System.out.println();
            return true;
        }
        return isContinue();
    }

    private void isSame(int num, int index) {
        ArrayList<Integer> list = myPlayer.getNumberSet();

        if (list.get(index).equals(num)) {
            strikeCount = strikeCount + 1;
        } else if (list.contains(num)) {
            ballCount = ballCount + 1;
        }
    }

    private void printStrike() {
        if (strikeCount != 0) {
            System.out.print(Integer.toString(strikeCount) + Constant.STR_STRIKE);
        }
    }

    private void printBall() {
        if (ballCount != 0) {
            System.out.print(Integer.toString(ballCount) + Constant.STR_BALL);
        }
    }

    private void printNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(Constant.STR_NOTHING);
        }
    }

    private void printEndGame() {
        System.out.println(Constant.STR_END_GAME);
        System.out.println(Constant.STR_QUESTION);
    }

    private boolean isContinue() {
        int input;

        printStrike();
        printEndGame();
        do {
            input = in.nextInt();
        } while (!checkValidation(input));
        if (input == 1) {
            myComputer.restartGame();
            return true;
        }
        return false;
    }

    private boolean checkValidation(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        System.out.println(Constant.STR_VALIDATION);
        return false;
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.run();
    }
}