package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.HashSet;
import java.util.Set;

// Strike, Ball 카운트를 위한 클래스
class StrikeAndBall {
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
    // RANDOM NUMBER
    public static final int NUMBER_START_INCLUSIVE = 100;
    public static final int NUMBER_END_INCLUSIVE = 999;

    // GAME PLAY
    public static final String GUESS_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String GUESS_INPUT_ERROR_MESSAGE = "1 에서 9 사이의 서로 다른 숫자로 이루어진 3자리 정수만 입력 가능합니다";

    // HINT
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    // AFTER GAME
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_QUIT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String RESTART_OR_QUIT_INPUT_ERROR_MESSAGE = "1 혹은 2만 입력 가능합니다";
    public static final String QUIT_MESSAGE = "GG";

    public static int[] intToArray(int num) {
        int[] this_array = new int[3];
        for (int i = 2; i > -1; i--) {
            this_array[i] = num % 10;
            num /= 10;
        }
        return this_array;
    }

    public static boolean isValidNum(int candidateNum) {
        Set<Integer> previousDigitSet = new HashSet<>();

        // 각 자리수 숫자가 서로 다르고 0이 아니어야 함
        int[] candidateArray = intToArray(candidateNum);
        for (int candidateDigit : candidateArray) {
            if (previousDigitSet.contains(candidateDigit) || candidateDigit == 0) {
                return false;
            }
            previousDigitSet.add(candidateDigit);
        }
        return true;
    }

    public static int getRandomNum() {
        int randomNum;
        do {
            randomNum = RandomUtils.nextInt(NUMBER_START_INCLUSIVE, NUMBER_END_INCLUSIVE);
        } while (!isValidNum(randomNum));
        return randomNum;
    }

    public static int guessNum(Scanner scanner) throws IllegalArgumentException {
        System.out.print(GUESS_INPUT_MESSAGE);
        // 정수가 아닌 경우
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int guessInput = scanner.nextInt();

        // valid한 3자리 정수만
        if (100 <= guessInput && guessInput < 1000 && isValidNum(guessInput)) {
            return guessInput;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int getGuessNum(Scanner scanner) {
        boolean isValidGuess = false;
        int number = 123; // initialize with meaningless number (123) to compile without error
        while (!isValidGuess) {
            try {
                number = guessNum(scanner);
                isValidGuess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(GUESS_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
        return number;
    }

    public static StrikeAndBall getStrikeAndBall(int guessNum, int answer) {
        int[] guessArray = intToArray(guessNum);
        int[] answerArray = intToArray(answer);

        return countStrikeAndBall(guessArray, answerArray);
    }

    public static StrikeAndBall countStrikeAndBall(int[] guessArray, int[] answerArray) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int playerDigitLoc = 0; playerDigitLoc < 3; playerDigitLoc++) {
            int playerDigitToCompare = guessArray[playerDigitLoc];

            for (int answerDigitLoc = 0; answerDigitLoc < 3; answerDigitLoc++) {
                int answerDigitToCompare = answerArray[answerDigitLoc];

                strikeCount += isStrike(playerDigitToCompare, playerDigitLoc, answerDigitToCompare, answerDigitLoc);
                ballCount += isBall(playerDigitToCompare, playerDigitLoc, answerDigitToCompare, answerDigitLoc);
            }
        }
        return new StrikeAndBall(strikeCount, ballCount);
    }

    public static int isStrike(int playerDigitToCompare, int playerDigitLoc, int answerDigitToCompare, int answerDigitLoc) {
        if (playerDigitLoc == answerDigitLoc && playerDigitToCompare == answerDigitToCompare) {
            return 1;
        }
        return 0;
    }

    public static int isBall(int playerDigitToCompare, int playerDigitLoc, int answerDigitToCompare, int answerDigitLoc) {
        if (playerDigitLoc != answerDigitLoc && playerDigitToCompare == answerDigitToCompare) {
            return 1;
        }
        return 0;
    }

    public static int getResultOfGuess(StrikeAndBall thisTurnResult) {
        int strikeCount = thisTurnResult.getStrike();
        int ballCount = thisTurnResult.getBall();

        if (0 < strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        } else if (0 < strikeCount && 0 == ballCount) {
            System.out.println(strikeCount + STRIKE);
        } else if (0 == strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL);
        } else if (0 == strikeCount && 0 == ballCount) {
            System.out.println(NOTHING);
        }
        return strikeCount;
    }

    public static void playGame(Scanner scanner, int answer) {
        int strikeCount = 0;
        while (strikeCount != 3) {
            int number = getGuessNum(scanner);
            StrikeAndBall thisTurnResult = getStrikeAndBall(number, answer);
            strikeCount = getResultOfGuess(thisTurnResult);
        }
    }

    public static void decideGoOrStop(Scanner scanner) throws IllegalArgumentException {
        System.out.println(RESTART_OR_QUIT_INPUT_MESSAGE);
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int input = scanner.nextInt();

        if (input == 1) {
            main(null);
        } else if (input == 2) {
            System.out.println(QUIT_MESSAGE);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void goOrStop (Scanner scanner) {
        System.out.println(WIN_MESSAGE);
        scanner.nextLine();

        boolean isValidGoOrStop = false;
        while (!isValidGoOrStop) {
            try {
                decideGoOrStop(scanner);
                isValidGoOrStop = true;
            } catch (IllegalArgumentException e) {
                System.out.println(RESTART_OR_QUIT_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 숫자 생성
        int answer = getRandomNum();

        // 게임 플레이
        playGame(scanner, answer);

        // 게임 계속 플레이 혹은 종료
        goOrStop(scanner);
    }
}
