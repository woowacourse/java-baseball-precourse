package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import utils.RandomUtils;

/**
 * 게임 한 판에 필요한 것들을 관리합니다. 이번 판의 정답, 게임에 필요한 기능을 관리합니다.
 * 
 * @author junroot
 */
public class GameManager {
    public static final int NUMBER_ANSWER = 3; // 정답 개수
    private int[] answer;

    /**
     * Game 상태를 나타냅니다.
     * 
     * ONGOING 아직 게임이 진행되는 상태입니다. RESTART 게임 한 판이 종료되고 재시작을 선택한 상태입니다. END 게임 한 판이 종료되고 게임 종료를 선택한
     * 상태입니다.
     * 
     * @author junroot
     */
    public static enum GameStatus {
        ONGOING(0), RESTART(1), END(2);

        private final int value;

        GameStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * GameManager가 생성되면 랜덤한 정답을 만듭니다.
     */
    public GameManager() {
        this.generateAnswer();
    }

    /**
     * 이 메소드를 호출하면 새로운 정답을 생성합니다.
     */
    public void generateAnswer() {
        answer = new int[NUMBER_ANSWER];
        for (int i = 0; i < NUMBER_ANSWER; i++) {
            int temp = RandomUtils.nextInt(1, 9);
            if (this.checkRedundancy(i, temp)) {
                i--; // 만약 기존에 사용된 숫자라면 다시 값을 받아온다.
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
    public boolean checkAnswer(ArrayList<Integer> userAnswer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_ANSWER; i++) {
            int index = this.findIndexOfAnswer(userAnswer.get(i));
            if (index == -1) {
                continue;
            } else if (index == i) {
                strike++;
            } else {
                ball++;
            }
        }
        this.printScore(strike, ball);
        return (strike == NUMBER_ANSWER);
    }

    /**
     * answer에서 number가 위치하는 인덱스를 찾습니다.
     * 
     * @param number 찾고자하는 숫자를 입력합니다.
     * @return 정답에 위치한 숫자의 인덱스를 반환합니다. 없다면 -1이 반환됩니다.
     */
    private int findIndexOfAnswer(int number) {
        for (int i = 0; i < NUMBER_ANSWER; i++) {
            if (answer[i] == number) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 입력받은 strike와 ball로부터 스코어를 출력합니다.
     * 
     * @param strike 스트라이크 개수입니다.
     * @param ball 볼 개수입니다.
     */
    private void printScore(int strike, int ball) {
        if ((ball == 0) && (strike == 0)) {
            System.out.print("낫싱");
        } else {
            if (ball > 0) {
                System.out.printf("%d볼 ", ball);
            }
            if (strike > 0) {
                System.out.printf("%d스트라이크", strike);
            }
        }
        System.out.println();
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
     * 사용자가 게임을 새로 시작하는지 입력을 받습니다. 1또는 2를 입력받지 않으면 예외처리합니다.
     * 
     * @param scanner 입력으로 사용할 Scanner를 입력합니다. 일반적으로 System.in입니다.
     * @return 입력된 값
     */
    public int requestReplay(Scanner scanner) {
        int number = requestInput(scanner);
        if ((number != 1) && (number != 2)) {
            throw new IllegalArgumentException();
        }
        return number;
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
