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
            System.out.print("숫자를 입력해주세요: ");
            input = in.next();
            playerResult = myPlayer.inputNumber(input);
            isRun = checkResult(playerResult);
        } while (isRun);
    }

    private boolean checkResult(String result) {
        switch (result) {
            case "":
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

        for (int i = 0; i < 3; i++) {
            isSame(list.get(i), i);
        }
        if (strikeCount != 3) {
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
            System.out.print(Integer.toString(strikeCount) + " 스트라이크 ");
        }
    }

    private void printBall() {
        if (ballCount != 0) {
            System.out.print(Integer.toString(ballCount) + " 볼 ");
        }
    }

    private void printNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
    }

    private void printEndGame() {
        System.out.println("\r\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        System.out.println("1 또는 2를 입력하세요.");
        return false;
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.run();
    }
}