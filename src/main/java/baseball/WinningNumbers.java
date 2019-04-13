package baseball;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean matchResult(Numbers userNumber) {
        int NUMBER_LENGTH = 3;
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userNumber.isStrike(i, numbers.get(i))) {
                strike++;
            } else if (userNumber.isBall(numbers.get(i))) {
                ball++;
            }
        }

        announceResult(Arrays.asList(strike, ball));

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void announceResult(List<Integer> matchResult) {
        int strike = matchResult.get(0);
        int ball = matchResult.get(1);
        String result = "";

        if ((ball == 0) && (strike == 0)) {
            result = "낫싱";
        } else if (strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = strike + "스트라이크 " + ball + "볼";
        }

        System.out.println(result);
    }
}
