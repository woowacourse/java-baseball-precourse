package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.HashSet;
import java.util.Set;

// Strike, Ball 카운트를 위한 클래스
final class StrikeAndBall {
    int strike;
    int ball;

    public StrikeAndBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

public class Application {

    public static int guessNum(Scanner scanner) throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        // 정수가 아닌 경우
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int input = scanner.nextInt();

        // valid한 3자리 정수만
        if (100 <= input && input < 1000 && isValidNum(input)) {
            return input;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void decideGoOrStop(Scanner scanner) throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int input = scanner.nextInt();

        if (input == 1) {
            main(null);
        } else if (input == 2) {
            System.out.println("GG");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void goOrStop (Scanner scanner) {
        boolean isValidGoOrStop = false;
        while (!isValidGoOrStop) {
            try {
                decideGoOrStop(scanner);
                isValidGoOrStop = true;
            } catch (IllegalArgumentException e) {
                System.out.println("1 혹은 2만 입력 가능합니다");
                scanner.nextLine();
            }
        }
    }

    public static int[] intToArray(int num) {
        int[] this_array = new int[3];
        for (int i = 2; i > -1; i--) {
            this_array[i] = num % 10;
            num /= 10;
        }
        return this_array;
    }

    public static boolean isValidNum(int candidate) {
        Set<Integer> store = new HashSet<>();

        // 각 자리수 숫자가 서로 다르고 0이 아니어야 함
        int[] candidate_array = intToArray(candidate);
        for (int i : candidate_array) {
            if (store.contains(i) || i == 0) {
                return false;
            }
            store.add(i);
        }
        return true;
    }

    public static StrikeAndBall countStrikeAndBall(int guessNum, int answer) {
        int[] guessArray = intToArray(guessNum);
        int[] answerArray = intToArray(answer);
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                strike += isStrike(guessArray[i], i, answerArray[j], j);
                ball += isBall(guessArray[i], i, answerArray[j], j);
            }
        }
        return new StrikeAndBall(strike, ball);
    }

    public static int isStrike(int num1, int index1, int num2, int index2) {
        if (index1 == index2 && num1 == num2) {
            return 1;
        }
        return 0;
    }

    public static int isBall(int num1, int index1, int num2, int index2) {
        if (index1 != index2 && num1 == num2) {
            return 1;
        }
        return 0;
    }

    public static void resultOfGuess(int strikeCount, int ballCount) {
        if (0 < strikeCount && 0 < ballCount) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        else if (0 < strikeCount && 0 == ballCount) {
            System.out.println(strikeCount + "스트라이크");
        }
        else if (0 == strikeCount && 0 < ballCount) {
            System.out.println(ballCount + "볼");
        }
        else if (0 == strikeCount && 0 == ballCount) {
            System.out.println("낫싱");
        }
    }

    public static int playGame(Scanner scanner, int answer) {
        boolean isValidGuess = false;
        int number = 123;
        while (!isValidGuess) {
            try {
                number = guessNum(scanner);
                isValidGuess = true;
            } catch (IllegalArgumentException e) {
                System.out.println("서로 다른 숫자로 이루어진 3자리 정수만 입력 가능합니다");
                scanner.nextLine();
            }
        }

        StrikeAndBall thisTurnResult = countStrikeAndBall(number, answer);
        int strikeCount = thisTurnResult.getStrike();
        int ballCount = thisTurnResult.getBall();
        resultOfGuess(strikeCount, ballCount);
        return strikeCount;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 숫자 생성
        int answer;
        do {
            answer = RandomUtils.nextInt(100, 999);
        } while (!isValidNum(answer));
        System.out.println(answer);

        int strikeCount = 0;
        while (strikeCount != 3) {
            strikeCount = playGame(scanner, answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        // 게임 계속 플레이 혹은 종료
        goOrStop(scanner);
    }
}
