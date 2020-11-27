package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import constants.SystemMessage;
import utils.RandomUtils;

public class BaseBall {
    private static final int RADIX = 10;
    private static final int DIGIT_NUM = 3;
    private final Scanner scanner;
    private String userNum;
    private String randNum;

    public BaseBall(Scanner scanner) {
        this.scanner = scanner;
        userNum = "";
        randNum = "";
    }

    public String getRandNum() {
        return randNum;
    }

    public void init() {
        randNum = makeRandNum(DIGIT_NUM);
    }

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

        return "";
		// return getHint(ballNum, strikeNum);
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
}
