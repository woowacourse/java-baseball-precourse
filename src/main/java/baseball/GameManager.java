package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import utils.RandomUtils;

/**
 * 게임 한 판에 필요한 것들을 관리합니다. 이번 판의 정답, 게임에 필요한 기능을 관리합니다.
 * 
 * @author junroot
 */
public class GameManager {
    public static final int NUMBER_ANSWER = 3; // 정답 개수
    private static final int MIN_ANSWER_NUMBER = 1; // 정답으로 가질 수 있는 최소 숫자
    private static final int MAX_ANSWER_NUMBER = 9; // 정답으로 가질 수 있는 최대 숫자
    private ArrayList<Integer> answer;
    private GameStatus gameStatus;

    /**
     * GameManager가 생성되면 랜덤한 정답을 만듭니다.
     */
    public GameManager() {
        this.generateAnswer();
        gameStatus = GameStatus.ONGOING;
    }

    /**
     * 입력받은 answer를 정답으로 가지는 게임을 생성합니다.
     * 
     * @param first 정답의 첫번째 숫자입니다.
     * @param second 정답의 두번째 숫자입니다.
     * @param third 정답의 세번째 숫자입니다.
     */
    public GameManager(Integer first, Integer second, Integer third) {
        this.answer = new ArrayList<Integer>();
        answer.add(first);
        answer.add(second);
        answer.add(third);
        gameStatus = GameStatus.ONGOING;
    }

    /**
     * 이 메소드를 호출하면 새로운 정답을 생성합니다.
     */
    public void generateAnswer() {
        answer = new ArrayList<Integer>();
        for (int i = 0; i < NUMBER_ANSWER;) {
            int temp = RandomUtils.nextInt(MIN_ANSWER_NUMBER, MAX_ANSWER_NUMBER);
            if (findIndexOfList(answer, i, temp) == -1) {
                // 중복된 값이 아니면 answer에 추가합니다.
                answer.add(temp);
                i++;
            }
        }
    }

    /**
     * userAnswer를 answer와 비교 후, 스트라이크와 볼의 개수를 반환합니다. 정답이라면 gameStatus가 WAIT상태로 갱신됩니다.
     * 
     * @param userAnswer 검사할 정답을 입력합니다.
     * @return 배열의 첫번쨰 값은 스트라이크, 두번째 값은 볼의 개수입니다.
     */
    public GameResult checkAnswer(ArrayList<Integer> userAnswer) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < NUMBER_ANSWER; i++) {
            int index = findIndexOfList(answer, NUMBER_ANSWER, userAnswer.get(i));
            if (index == i) {
                // 정답에서 숫자의 위치와 같다면 strike 입니다.
                gameResult.increaseStrike();
            } else if (index != -1) {
                gameResult.increaseBall();
            }
        }
        if (gameResult.getStrike() == NUMBER_ANSWER) {
            // 스트라이크가 정답의 개수와 같으면 상태를 WAIT으로 설정합니다.
            gameStatus = GameStatus.WAIT;
        }
        return gameResult;
    }

    /**
     * list에서 number가 위치하는 인덱스를 찾습니다.
     * 
     * @param list 비교하고자하는 list를 입력합니다.
     * @param length 비교할 길이를 입력합니다.
     * @param number 찾고자하는 숫자를 입력합니다.
     * @return 정답에 위치한 숫자의 인덱스를 반환합니다. 없다면 -1이 반환됩니다.
     */
    private static int findIndexOfList(ArrayList<Integer> list, int length, int number) {
        for (int i = 0; i < length; i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 사용자가 게임을 새로 시작하는지 입력을 받습니다. 1또는 2를 입력받지 않으면 예외처리합니다. 입력을 받은 후 현재 게임의 상태를 갱신합니다.
     * 
     * @param scanner 입력으로 사용할 Scanner를 입력합니다. 일반적으로 System.in입니다.
     * @return 입력된 값을 반환합니다.
     */
    public void requestReplay(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equals(GameStatus.RESTART.getValue())) {
            this.generateAnswer();
            this.gameStatus = GameStatus.ONGOING;
        } else if (input.equals(GameStatus.END.getValue())) {
            this.gameStatus = GameStatus.END;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자에게 정답을 입력받고 ArrayList로 만들어 반환합니다.
     * 
     * @param scanner 입력으로 사용할 Scanner를 입력합니다. 일반적으로 System.in입니다.
     * @return 입력으로 받은 숫자의 ArrayList를 반환합니다.
     */
    public static ArrayList<Integer> requestUserAnswer(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.length() != NUMBER_ANSWER) {
            // input의 길이가 NUMBER_ANSWER와 다르면 예외처리합니다.
            throw new IllegalArgumentException();
        }
        return convertStringToUserAnswer(input);
    }

    /**
     * 입력으로 받은 String을 ArrayList<Integer> 형태로 반환합니다. 이 때, 0이 포함된 입력이면 예외처리합니다.
     * 
     * @param string String 형태로 입력을 받습니다.
     * @return ArrayList<Integer>로 변환하여 반환합니다.
     */
    private static ArrayList<Integer> convertStringToUserAnswer(String string) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < string.length(); i++) {
            Integer number = convertCharToInteger(string.charAt(i));
            if (findIndexOfList(result, i, number) != -1) {
                // 중복된 입력이 있을 수 없습니다.
                throw new IllegalArgumentException();
            }
            result.add(number);
        }
        return result;
    }

    /**
     * 입력 받은 문자를 Integer로 변홥합니다. 이 때 정답으로 나올 수 없는 문자면 예외처리됩니다.
     * 
     * @param ch 변환시킬 문자를 입력합니다.
     * @return Integer로 변환하여 반환합니다.
     */
    private static Integer convertCharToInteger(char ch) {
        int result = Character.getNumericValue(ch);
        if (result < MIN_ANSWER_NUMBER || result > MAX_ANSWER_NUMBER) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    /**
     * 현재 게임의 상태를 반환합니다.
     * 
     * @return 현재 게임의 상태입니다.
     */
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * 디버깅용입니다.
     * 
     * @return answer를 반환합니다.
     */
    protected ArrayList<Integer> getAnswer() {
        return answer;
    }
}
