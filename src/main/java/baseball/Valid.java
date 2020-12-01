package baseball;

import utils.RandomUtils;

/** 검증기준 */
public class Valid {
    private static final int GAME_DIGIT = 3;
    private static final String REPLAY = "1";
    private static final String FINISH_GAME = "2";

    /**
     * 새 게임을 위한 새 정답을 반환
     * @return 새 정답 문자열
     */
    public String newTarget() {
        StringBuilder target = new StringBuilder();
        while (target.length() < GAME_DIGIT) {
            String number = Integer.toString(RandomUtils.nextInt(1, 9));
            if (!target.toString().contains(number)) {
                target.append(number);
            }
        }
        return target.toString();
    }

    /**
     * 값이 적합하면 그대로 반환, 부적합시 예외 발생
     * @param input 입력값
     * @return 입력값
     */
    public String inputNumber(final String input) {
        numeric(input);
        size(input);
        return input;
    }

    /** 값이 숫자인지 확인 */
    private void numeric(final String input) {
        if (input.replaceAll("[\\d]", "").length() != 0) {
            throw new IllegalArgumentException("값이 숫자가 아닙니다.");
        }
    }

    /** 값의 길이가 적합한지 확인 */
    private void size(final String input) {
        if (input.length() != Valid.GAME_DIGIT) {
            throw new IllegalArgumentException(Valid.GAME_DIGIT + "자리가 아닙니다.");
        }
    }

    /** 값이 종료인지 확인 */
    public boolean isFinish(final String input) {
        rightAnswer(input);
        return input.equals(Valid.FINISH_GAME);
    }

    /** 값이 종료 또는 다시시작인지 확인 */
    private void rightAnswer(final String input) {
        if (!input.equals(Valid.FINISH_GAME) && !input.equals(Valid.REPLAY)) {
            throw new IllegalArgumentException("올바른 대답이 아닙니다.");
        }
    }
}
