package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import constants.SystemMessage;
import utils.RandomUtils;

public class BaseBall {
    private static final int RADIX = 10;
    private static final int DIGIT_NUM = 3;
    private static final String RESTART = "1";
    private static final String END = "2";
    private final Scanner scanner;
    private String userNum;
    private String randNum;

    public BaseBall(Scanner scanner) {
        this.scanner = scanner;
        userNum = "";
        randNum = "";
    }

    public void init() {
        randNum = makeRandNum(DIGIT_NUM);
    }

    // 유저가 입력한 수와 난수가 같을 때까지 반복함.
    public void playGame() {
        String result = "";

        do {
            System.out.print(SystemMessage.INPUT_MESSAGE);
            userNum = next();
            result = umpire();
            System.out.println(result);
        } while (!result.equals(SystemMessage.GAME_CLEAR_MESSAGE));
    }

    // 유저가 입력한 수에 따라 볼과 스트라이크를 판단하고 힌트를 제공함.
    private String umpire() {
        int ballNum = 0;
        int strikeNum = 0;

        for (int i = 0; i < DIGIT_NUM; i++) {
            char digit = userNum.charAt(i);

            if (isStrike(digit, i)) {
                strikeNum++;
            } else if (isBall(digit)) {
                ballNum++;
            }
        }
        return getHint(ballNum, strikeNum);
    }

    // umpire에서 구한 볼과 스트라이크 개수에 따라
    // 구체적인 힌트를 반환함.
    private String getHint(final int ballNum, final int strikeNum) {
        if (strikeNum == DIGIT_NUM) {
            return SystemMessage.GAME_CLEAR_MESSAGE;
        } else if (ballNum == 0 && strikeNum == 0) {
            return SystemMessage.NOTHING;
        } else if (ballNum == 0) {
            return strikeNum + SystemMessage.STRIKE;
        } else if (strikeNum == 0) {
            return ballNum + SystemMessage.BALL;
        }
        return ballNum + SystemMessage.BALL + " " + strikeNum + SystemMessage.STRIKE;
    }

    private boolean isStrike(final char digit, final int pos) {
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (digit == randNum.charAt(i) && pos == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isBall(final char digit) {
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (digit == randNum.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    // 1에서 9까지 서로 다른 임의의 세 자리 난수를 생성함.
    private String makeRandNum(final int digit) {
        Set<Character> randNumSet = new HashSet<>();
        int cnt = 0;
        String result = "";

        while (cnt < digit) {
            char temp = Character.forDigit(RandomUtils.nextInt(1, 9), RADIX);

            if (randNumSet.contains(temp)) {
                continue;
            }

            randNumSet.add(temp);
            result += temp;
            cnt++;
        }
        return result;
    }

    // 게임이 끝났을 때, 유저에게 게임 재시작 여부를 물어 봄.
    public boolean isUserWantContinue() {
        System.out.println(SystemMessage.GAME_RESTART_OR_END_MESSAGE);
        String sel = scanner.next();

        if (sel.equals(RESTART)) {
            return true;
        } else if (sel.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    // 유저가 입력한 세 자리 수에 대해 입력 검사를 함.
    private String next() {
        String input = scanner.next();

        if (input.length() != DIGIT_NUM) {
            throw new IllegalArgumentException();
        }

        char compare = input.charAt(0);

        if (compare == '0') {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < input.length(); i++) {
            if (compare == input.charAt(i)) {
                throw new IllegalArgumentException();
            }

            if (input.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }
}
