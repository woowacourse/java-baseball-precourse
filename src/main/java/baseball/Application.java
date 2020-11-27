package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.HashSet;
import java.util.Set;

// Class for Strike and Ball count
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
    // CONSTANTS FOR RANDOM NUMBER
    private static final int NUMBER_START_INCLUSIVE = 100;
    private static final int NUMBER_END_INCLUSIVE = 999;

    // CONSTANTS FOR GAME PLAY
    private static final String GUESS_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GUESS_INPUT_ERROR_MESSAGE = "1 에서 9 사이의 서로 다른 숫자로 이루어진 3자리 정수만 입력 가능합니다";

    // CONSTANTS FOR HINT
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    // CONSTANTS FOR AFTER GAME
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "1 혹은 2만 입력 가능합니다";
    private static final String QUIT_MESSAGE = "GG";

    public static int[] convertIntToArray(int num) {
        int[] thisArray = new int[3];
        for (int i = 2; i > -1; i--) {
            thisArray[i] = num % 10;
            num /= 10;
        }
        return thisArray;
    }

    public static boolean isValidNum(int candidateNum) {
        Set<Integer> previousDigitSet = new HashSet<>();

        // all 3 digits MUST BE different and NOT BE 0
        int[] candidateArray = convertIntToArray(candidateNum);
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

    public static int tryToGuessNum(Scanner scanner) throws IllegalArgumentException {
        System.out.print(GUESS_INPUT_MESSAGE);
        // input is not an integer
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int guessInput = scanner.nextInt();

        // input has 3 digits and valid number
        if (100 <= guessInput && guessInput < 1000 && isValidNum(guessInput)) {
            return guessInput;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int getPlayerNum(Scanner scanner) {
        boolean isValidGuess = false;
        int playerNum = 123; // initialize with meaningless number (123) to compile without error
        while (!isValidGuess) {
            try {
                playerNum = tryToGuessNum(scanner);
                isValidGuess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(GUESS_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
        return playerNum;
    }

    public static StrikeAndBall countStrikeAndBall(int[] playerNumArray, int[] answerNumArray) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int playerDigitLoc = 0; playerDigitLoc < 3; playerDigitLoc++) {
            int playerDigit = playerNumArray[playerDigitLoc];

            for (int answerDigitLoc = 0; answerDigitLoc < 3; answerDigitLoc++) {
                int answerDigit = answerNumArray[answerDigitLoc];

                strikeCount += isStrike(playerDigit, playerDigitLoc, answerDigit, answerDigitLoc);
                ballCount += isBall(playerDigit, playerDigitLoc, answerDigit, answerDigitLoc);
            }
        }
        return new StrikeAndBall(strikeCount, ballCount);
    }

    public static int isStrike(int playerDigit, int playerDigitLoc, int answerDigit, int answerDigitLoc) {
        if (playerDigitLoc == answerDigitLoc && playerDigit == answerDigit) {
            return 1;
        }
        return 0;
    }

    public static int isBall(int playerDigit, int playerDigitLoc, int answerDigit, int answerDigitLoc) {
        if (playerDigitLoc != answerDigitLoc && playerDigit == answerDigit) {
            return 1;
        }
        return 0;
    }

    public static StrikeAndBall getStrikeAndBall(int playerNum, int answerNum) {
        int[] playerNumArray = convertIntToArray(playerNum);
        int[] answerNumArray = convertIntToArray(answerNum);

        return countStrikeAndBall(playerNumArray, answerNumArray);
    }

    public static int getResultOfGuess(StrikeAndBall thisTurnResult) {
        int strikeCount = thisTurnResult.getStrike();
        int ballCount = thisTurnResult.getBall();

        if (0 < strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE);
        } else if (0 < strikeCount && 0 == ballCount) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
        } else if (0 == strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL_MESSAGE);
        } else if (0 == strikeCount && 0 == ballCount) {
            System.out.println(NOTHING_MESSAGE);
        }
        return strikeCount;
    }

    public static void playGame(Scanner scanner, int answerNum) {
        int strikeCount = 0;
        while (strikeCount != 3) {
            int playerNum = getPlayerNum(scanner);
            StrikeAndBall thisTurnResult = getStrikeAndBall(playerNum, answerNum);
            strikeCount = getResultOfGuess(thisTurnResult);
        }
    }

    public static void decideReplayOrQuit(Scanner scanner) throws IllegalArgumentException {
        System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int replayOrQuitInput = scanner.nextInt();

        if (replayOrQuitInput == 1) {
            main(null);
        } else if (replayOrQuitInput == 2) {
            System.out.println(QUIT_MESSAGE);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void replayOrQuit(Scanner scanner) {
        System.out.println(WIN_MESSAGE);
        scanner.nextLine();

        boolean isValidReplayOrQuitInput = false;
        while (!isValidReplayOrQuitInput) {
            try {
                decideReplayOrQuit(scanner);
                isValidReplayOrQuitInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        int answer = getRandomNum(); // GENERATE ANSWER
        playGame(scanner, answer);
        replayOrQuit(scanner);
    }
}
