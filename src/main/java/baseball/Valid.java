package baseball;

import utils.RandomUtils;

/** 검증기준 */
public class Valid {
    private static final int GAME_DIGIT = 3;

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
}
