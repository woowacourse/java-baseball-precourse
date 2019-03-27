package game;

import util.RandomNumberGenerator;

/**
 * @author delf
 */
public class Baseball {
    public final static int BASIC_NUMBER_COUNT = 3;
    public final static int BASIC_NUMBER_MIN = 1;
    public final static int BASIC_NUMBER_MAX = 9;

    private int[] numbers;
    private boolean isDone = false;

    /***
     * 랜덤 숫자를 생성하고 게임을 시작한다. 숫자의 개수, 숫자의 범위는 기본값을 따른다.
     * @see Baseball#start(int, int, int)
     */
    public void start() {
        start(BASIC_NUMBER_COUNT, BASIC_NUMBER_MIN, BASIC_NUMBER_MAX);
    }

    /**
     * @see Baseball#start()
     */
    private void start(int n, int min, int max) {
        numbers = RandomNumberGenerator.getUniqueNumbers(n, min, max).byIntegerArray();
    }

    /**
     * 임의의 숫자가 아닌 지정한 숫자로 게임을 시작한다.
     * @param numbers 지정된 숫자가 저장된 정수 배열
     */
    public void start(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * 한 세트를 실행한다. 한 세트는 사용자가 입력한 숫자들과 생성된 숫자들을 비교하여 본 게임의 규칙에
     * 따라 힌트에 해당하는 결과를 반환하는 과정이다. 규칙은를 다음은 참조하라.
     * https://github.com/Delf-Lee/java-baseball/blob/delf/README.md
     *
     * @param inputNumbers 사용자가 입력한 숫자들로 이루어진 정수 배열
     * @return 규칙에 따른 결과를 담은 {@link OneSetResult} 객체
     */
    public OneSetResult playOneSetGame(int[] inputNumbers) {
        int strike = 0;
        int ball = 0;

        /* Note: 성능 이슈를 감안하여 문자열이 아닌 배열로 처리한다. */

        for (int i = 0; i < inputNumbers.length; i++) {
            int index = findIndex(inputNumbers[i]);
            if (index != -1 && index == i) {
                strike++;
            }
            if (index != -1 && index != i) {
                ball++;
            }
        }

        return new OneSetResult(strike, ball);
    }

    /**
     * @param num
     * @return
     */
    private int findIndex(int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
