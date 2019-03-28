package game.model;

import util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author delf
 */
public class Baseball {
    public final static int BASIC_NUMBER_COUNT = 3;
    public final static int BASIC_NUMBER_MIN = 1;
    public final static int BASIC_NUMBER_MAX = 9;

    private int[] numbers;

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
     *
     * @param numbers 지정된 숫자가 저장된 정수 배열
     * @throws IllegalArgumentException 사용자가 입력 배열의 원소가 올바르지 않으면 예외를 던진다.
     * {@link Baseball#checkInput(int[])}
     */
    public void start(int[] numbers) {
        checkInput(numbers);
        this.numbers = numbers;
    }

    /**
     * 게임 한 세트를 실행한다. 한 세트는 사용자가 입력한 숫자들과 생성된 숫자들을 비교하여 본 게임의 규칙에
     * 따라 힌트에 해당하는 결과를 반환하는 과정이다. 규칙은를 다음은 참조하라.
     * https://github.com/Delf-Lee/java-baseball/blob/delf/README.md
     *
     * @param inputNumbers 사용자가 입력한 숫자들로 이루어진 정수 배열
     * @return 규칙에 따른 결과를 담은 {@link OneSetResult} 객체
     * @throws IllegalArgumentException 사용자가 입력 배열의 원소가 올바르지 않으면 예외를 던진다.
     * {@link Baseball#checkInput(int[])}
     */
    public OneSetResult playOneSetGame(int[] inputNumbers) throws IllegalArgumentException {
        checkInput(inputNumbers);

        int strike = 0;
        int ball = 0;

        /* Note: 성능 이슈를 감안하여 문자열이 아닌 배열로 처리한다. */
        for (int i = 0; i < inputNumbers.length; i++) {

            int index;
            try {
                index = findIndex(inputNumbers[i]);
            } catch (NoSuchElementException e) {
                continue;
            }

            if (index == i) {
                strike++;
            }
            if (index != i) {
                ball++;
            }

        }

        return new OneSetResult(strike, ball);
    }

    /**
     * @param num 사용자가 입력한 임의의 숫자 중 임의의 정수
     * @return num이 numbers에 존재하면 해당 인덱스, 없으면 -1을 반환한다.
     * @throws NoSuchElementException 해당 원소가 없으면 예외를 던진다.
     */
    private int findIndex(int num) throws NoSuchElementException {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * @param arr 임의의 배열
     * @return 배열의 원소 수가 일치하지 않거나, 올바른 원소가 아니거나, 중복 원소 존재 하면 예외를 던진다.
     */
    private void checkInput(int[] arr) {
        if(arr.length != numbers.length) {
            /* 원소의 수가 일치하지 않음 */
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if(n == 0) {
                /* 올바른 원소가 아님 */
                throw new IllegalArgumentException();
            }
            set.add(n);
        }

        if(set.size() != arr.length) {
            /* 중복되는 원소가 있음 */
            throw new IllegalArgumentException();
        }
    }
}
