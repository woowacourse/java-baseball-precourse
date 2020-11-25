package baseball;

import java.util.Arrays;
import utils.RandomUtils;

/**
 * 게임 한 판에 필요한 것들을 관리합니다. 이번 판의 정답, 정답 확인 등을 관리합니다.
 */
public class GameManager {
    public static final int NUMBER_ANSWER = 3; // 정답 개수
    private int answer[];

    /**
     * GameManager가 생성되면 랜덤한 정답을 만듭니다.
     */
    public GameManager() {
        answer = new int[NUMBER_ANSWER];
        for (int i = 0; i < NUMBER_ANSWER; i++) {
            int temp = RandomUtils.nextInt(1, 9);
            if (this.checkRedundancy(i, temp)) {

                /* 만약 기존에 사용된 숫자라면 다시 값을 받아온다. */
                i--;
            } else {
                answer[i] = temp;
            }
        }
    }

    /**
     * answer에 number가 존재하는이 to까지 확인합니다.
     * 
     * @param to 검사할 길이를 입력합니다.
     * @param number 비교할 숫자를 입력합니다.
     * @return 중복된 값이 있으면 true, 없으면 false를 반환합니다.
     */
    private boolean checkRedundancy(int to, int number) {
        for (int i = 0; i < to; i++) {
            if (answer[i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 디버깅용입니다.
     * 
     * @return answer를 반환합니다.
     */
    protected String getAnswer() {
        return Arrays.toString(answer);
    }
}
