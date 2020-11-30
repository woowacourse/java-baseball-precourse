package baseball.domain;

import baseball.model.GameResult;
import utils.BaseballDigitsGenerator;

import java.util.List;

/**
 * 랜덤한 값을 생성받아 플레이어의 입력값이 맞는지 판별하는 클래스입니다.
 * 불변의 형태로 하나의 Computer당 하나의 랜덤 값을 가질 수 있으며,
 * 새로운 게임 (새로운 라운드)를 실행하기 위해서는 새로운 Computer 객체를 생성해야 합니다.
 */
public class Computer {

    private List<Integer> targetDigits;

    public Computer() {
        init();
    }

    private void init() {
        this.targetDigits = BaseballDigitsGenerator.generateRandomDigitsList();
    }

    public void setTargetDigits(List<Integer> targetDigits) {
        this.targetDigits = targetDigits;
    }

    /** 플레이어의 입력 값이 랜덤 숫자와 맞는지 체크하는 함수 */
    public String guessTargetDigits(List<Integer> guessDigits) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < BaseballDigitsGenerator.BASEBALL_LEN; i++) {
            int guessDigit = guessDigits.get(i);
            int targetDigit = targetDigits.get(i);

            if (targetDigit == guessDigit) {
                gameResult.countStrike();
            }

            if (targetDigit != guessDigit && targetDigits.contains(guessDigit)) {
                gameResult.countBall();
            }
        }
        return gameResult.getResult();
    }
}
