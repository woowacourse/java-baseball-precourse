package baseball;

import java.util.HashSet;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int INPUT_RESTART = 1;
    private static final int INPUT_STOP = 2;

    private static boolean isPlaying = true;

    private int[] computerNums = new int[3];
    private int[] playerNums = new int[3];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        while (isPlaying) {
            application.gameStart(scanner);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int input = scanner.nextInt();
            if (input == INPUT_RESTART) {
                isPlaying = true;
            } else if (input == INPUT_STOP) {
                isPlaying = false;
            } else {
                throw new IllegalArgumentException("input only 1 or 2");
            }
        }
    }

    private void gameStart(Scanner scanner) {
        initComputerNums();
        while (true) {
            inputPlayerNums(scanner);
            printResult();
            if (isCorrectAnswer()) {
                break;
            }
        }
    }

    private void validateInput(int input) {
        String inputString = String.valueOf(input);
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("input only 3 digits");
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            int num = Integer.valueOf(inputString.substring(i, i + 1));
            if (set.contains(num)) {
                throw new IllegalArgumentException("number duplicate");
            }

            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("number range is 1 ~ 9");
            }
            set.add(num);
        }
    }

    private void inputPlayerNums(Scanner scanner) {
        int input = scanner.nextInt();
        validateInput(input);

        String[] split = String.valueOf(input).split("");
        for (int i = 0; i < playerNums.length; i++) {
            playerNums[i] = Integer.valueOf(split[i]);
        }
    }

    private void initComputerNums() {
        for (int i = 0; i < computerNums.length; i++) {
            computerNums[i] = RandomUtils.nextInt(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
        }
    }

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
