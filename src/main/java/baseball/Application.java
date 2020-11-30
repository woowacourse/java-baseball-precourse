package baseball;

import java.util.Scanner;

public class Application {
    private final int INPUT_RESTART = 1;
    private final int INPUT_STOP = 2;

    private static boolean isPlaying = true;

    private Computer computer;
    private Player player;

    public Application() {
        computer = new Computer();
        player = new Player();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        while (isPlaying) {
            application.startGame(scanner);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            application.inputForRestart(scanner);
        }
    }

    private void inputForRestart(Scanner scanner) {
        int input = scanner.nextInt();
        if (input == INPUT_RESTART) {
            isPlaying = true;
        } else if (input == INPUT_STOP) {
            isPlaying = false;
        } else {
            throw new IllegalArgumentException("input only 1 or 2");
        }
    }

    private void startGame(Scanner scanner) {
        computer.makeRandomNumber();
        // initComputerNums();
        while (true) {
            player.inputThreeNumber(scanner);
            // printResult();
            // if (isCorrectAnswer()) {
            // break;
            // }
        }
    }

    // private void inputPlayerNums(Scanner scanner) {
    // int input = scanner.nextInt();
    // validateInput(input);
    //
    // String[] split = String.valueOf(input).split("");
    // for (int i = 0; i < playerNums.length; i++) {
    // playerNums[i] = Integer.valueOf(split[i]);
    // }
    // }

    private int getNumOfBalls() {
        int numOfBalls = 0;
        for (int i = 0; i < playerNums.length; i++) {
            if (hasNumberInComputerNums(playerNums[i], i)) {
                numOfBalls++;
            }
        }
        return numOfBalls;
    }

    private boolean hasNumberInComputerNums(int num, int index) {
        for (int i = 0; i < computerNums.length; i++) {
            if (i != index && num == computerNums[i]) {
                return true;
            }
        }
        return false;
    }

    private int getNumOfStrikes() {
        int numOfStrikes = 0;
        for (int i = 0; i < playerNums.length; i++) {
            if (playerNums[i] == computerNums[i]) {
                numOfStrikes++;
            }
        }
        return numOfStrikes;
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        int numOfBalls = getNumOfBalls();
        int numOfStrikes = getNumOfStrikes();
        if (numOfBalls > 0) {
            sb.append(numOfBalls);
            sb.append("볼 ");
        }

        if (numOfStrikes > 0) {
            sb.append(numOfStrikes);
            sb.append("스트라이크");
        }

        if (numOfBalls == 0 && numOfStrikes == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    private boolean isCorrectAnswer() {
        return getNumOfStrikes() == 3;
    }
}
