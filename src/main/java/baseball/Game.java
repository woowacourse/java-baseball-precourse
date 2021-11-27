package baseball;

import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import constants.HintMessage;

public class Game {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 9;
    private final int DIGIT_NUM = 3;
    private final int RADIX = 10;

    Game() {
    }

    public String generateRandomNumber() {
        String result = "";
        Set<Character> randomNumberSet = new HashSet<>();

        int numberLength = 0;
        while (numberLength < DIGIT_NUM) {
            int randomDigit = Randoms.pickNumberInRange(MIN_RANGE,
                    MAX_RANGE);
            char number = Character.forDigit(randomDigit, RADIX);

            if (randomNumberSet.contains(number)) {
                continue;
            }
            numberLength++;
            result += number;
            randomNumberSet.add(number);
        }

        return result;

    }

    public boolean playGame() {
        // n자리 임의의 난수 생성
        String randomNumber = generateRandomNumber();
        boolean isGameContinue = true;
        do {
            // 사용자 입력이 잘못된 값이면 IllegalArgumentException 발생 뒤 종료
            String userNumber = Console.readLine();
            boolean isValid = InputValidator.checkUserInput(userNumber);
            if (!isValid) {
                throw new IllegalArgumentException("사용자 입력이 잘못된 값이므로 게임을 종료합니다");
            }

            int ballCount = countBall(randomNumber, userNumber);
            int strikeCount = countStrike(randomNumber, userNumber);
            printHint(ballCount, strikeCount);

            if (ballCount == 0 && strikeCount == DIGIT_NUM) {
                isGameContinue = false;
            }

        } while (isGameContinue);
        return true;
    }

    public int countStrike(String opponentNumber, String userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (opponentNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(String opponentNumber, String userNumber) {
        int ballCount = 0;
        for (int i = 0; i < DIGIT_NUM; i++) {
            for (int j = 0; j < DIGIT_NUM; j++) {
                if (i != j && opponentNumber.charAt(i) == userNumber.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public void printHint(final int ballCount, final int strikeCount) {

        Assertions.assertTrue(ballCount <= DIGIT_NUM && strikeCount <= DIGIT_NUM);
        String hint = ballCount + HintMessage.BALL.message() + " " + strikeCount + HintMessage.STRIKE.message();
        if (ballCount == 0 && strikeCount == 0) {
            hint = HintMessage.NOTHING.message();
        } else if (ballCount == 0) {
            hint = strikeCount + HintMessage.STRIKE.message();
        } else if (strikeCount == 0) {
            hint = ballCount + HintMessage.BALL.message();
        }
        System.out.println(hint);
    }
}
