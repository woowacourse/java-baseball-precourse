package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import utils.NotImplemented;
import utils.RandomUtils;

/**
 * 게임 한 판에 필요한 것들을 관리합니다. 이번 판의 정답, 게임에 필요한 기능을 관리합니다.
 */
public class GameManager {
    public static final int NUMBER_ANSWER = 3; // 정답 개수
    private int[] answer;

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
     * userAnswer를 answer와 비교 후, 스트라이크와 볼의 개수를 출력합니다.
     * 
     * @param userAnswer 검사할 정답을 입력합니다.
     * @return 정답을 맞췄다면 true, 틀렸다면 false를 반환합니다.
     */
    @NotImplemented
    public boolean checkAnswer(ArrayList<Integer> userAnswer) {
        return true;
    }

    /**
     * 사용자에게 받은 숫자 입력을 확인하여 예외처리를 하고 값을 반합니다.
     *
     * @param scanner 입력으로 사용할 Scanner를 입력합니다. 일반적으로 System.in입니다.
     * @return 입력으로 받은 숫자를 반환합니다.
     */
    public int requestInput(Scanner scanner) {
        int result = 0;
        try {
            result = scanner.nextInt();
        } catch (Exception e) {
            IllegalArgumentException iae = new IllegalArgumentException();
            iae.initCause(e);
            throw iae;
        }
        return result;
    }

    /**
     * 사용자에게 정답을 요청하고 ArrayList로 만들어 반환합니다.
     * 
     * @param scanner 입력으로 사용할 Scanner를 입력합니다. 일반적으로 System.in입니다.
     * @return 입력으로 받은 숫자의 ArrayList를 반환합니다.
     */
    public ArrayList<Integer> requestAnswer(Scanner scanner) {
        int number = requestInput(scanner);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (number > 0) {
            int temp = number % 10;
            if (temp == 0) {
                /* 입력은 1~9만 가능하다. */
                throw new IllegalArgumentException();
            }
            result.add(number % 10);
            number /= 10;
        }
        if (result.size() != NUMBER_ANSWER) {
            throw new IllegalArgumentException();
        }
        Collections.reverse(result);
        return result;
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
